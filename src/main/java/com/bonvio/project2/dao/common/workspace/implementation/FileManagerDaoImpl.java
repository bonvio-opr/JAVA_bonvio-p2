package com.bonvio.project2.dao.common.workspace.implementation;

import com.bonvio.project2.classes.common.workspace.Folder;
import com.bonvio.project2.dao.BaseDao;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivan on 28.11.2014.
 */
public class FileManagerDaoImpl extends BaseDao {

    public FileManagerDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    //add only folder (catalog)
    public long addFolder(Folder folder, String userId) {
        try {

            //INSERT INTO "ARTI"."S_FOLDERS" (S_NAME, S_OWNER_ID, S_PARENT_ID, S_TYPE) VALUES ('111111', '5', '5', 'file')
            getJdbcTemplate().update("insert into " + defaultSchema + ".s_folders (s_name, s_owner_id, s_parent_id, s_type) values (?,?,?,?)",
                    folder.getName(),
                    userId,
                    folder.getParentId(),
                    folder.getType()
            );

            long folderId = getJdbcTemplate().queryForLong("select s_folders_extensions.currval as s_id from dual");
            return folderId;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка в добавлении папки");
            return 0;
        }
    }


    public List<Folder> getFolderByParentId(long id, String userId) {

        List<Folder> folders = new ArrayList<Folder>();
        try {
            folders.addAll(getJdbcTemplate().query(
                    "select s_id, s_name, s_owner_id, s_parent_id, s_type from s_folders  where s_owner_id= ? and s_parent_id = ?",
                    new RowMapper<Folder>() {
                        @Override
                        public Folder mapRow(ResultSet r, int i) throws SQLException {
                            return new Folder(
                                    r.getLong("S_ID"),
                                    r.getLong("S_OWNER_ID"),
                                    r.getLong("S_PARENT_ID"),
                                    r.getString("S_NAME"),
                                    r.getString("S_TYPE")
                            );
                        }
                    }, userId, id));
        } catch (Exception e) {
            System.out.println("Ошибка в получении папки");
            e.printStackTrace();
            return null;
        }
        return folders;
    }

    //update folder or file: name, parentId, type
    public long updateFolder(Folder folder, String userId) {

        String query =
                "UPDATE s_folders SET s_name = ?, s_parent_id = ?, s_type = ? WHERE s_id = ? AND s_owner_id = ?";
        try {
            getJdbcTemplate().update(query,
                    folder.getName(),
                    folder.getParentId(),
                    folder.getType(),
                    folder.getId(),
                    userId
            );

            long folderId = getJdbcTemplate().queryForLong("select s_folders_extensions.currval as s_id from dual");
            return folderId;

        } catch (Exception e) {
            System.out.println("Ошибка в обновлении папки");
            return 0;
        }
    }

    //deleting folders and files
    public void deleteFolder(long idFolder, String userId) {

        List<Folder> folders = getFolderByParentId(idFolder, userId);

        try {
            getJdbcTemplate().update("delete from " + defaultSchema + ".s_folders where s_id = ? and s_owner_id = ?", idFolder, userId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка в удалении файла или папки с ид = " + idFolder);
        }

        if (folders.size() > 0) {
            for (int i = 0; i < folders.size(); i++) {
                deleteFolder(folders.get(i).getId(), userId);
            }
        }
    }

    //add only one file
    public long uploadFile(MultipartFile file, long parentId, String userId) {

        String query = "insert into " + defaultSchema + ".s_folders (s_parent_id, s_owner_id, s_name, s_type, S_FILE) values (?,?,?,?,?)";

        try {
            LobHandler lobHandler = new DefaultLobHandler();
            String fileName = file.getOriginalFilename();
            System.out.println("fileName" + fileName);


            getJdbcTemplate().update(query,
                    new Object[]{
                            parentId,
                            userId,
                            fileName,
                            fileName.substring(fileName.lastIndexOf(".")+1),
                            new SqlLobValue(file.getInputStream(), (int) file.getSize(), lobHandler)
                    },
                    new int[]{
                            Types.BIGINT,
                            Types.VARCHAR,
                            Types.VARCHAR,
                            Types.VARCHAR,
                            Types.BLOB
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при добавлении файла в файловый менеджер");
        }
        return 0;
    }

    public long updateFile(MultipartFile file, long id, String userId) {

        try {
            LobHandler lobHandler = new DefaultLobHandler();

            getJdbcTemplate().update("UPDATE s_folders SET s_file = ? WHERE s_id = ? AND s_owner_id = ?",
                    new Object[]{
                            new SqlLobValue(file.getInputStream(), (int) file.getSize(), lobHandler),
                            id,
                            userId
                    },
                    new int[]{
                            Types.BLOB,
                            Types.BIGINT,
                            Types.VARCHAR,
                    }
            );
        } catch (Exception e) {
            System.out.println("Ошибка при обновлении содержимого файла в файловом менеджере");
        }
        return 0;
    }



    public long getFile(long id, String userId, HttpServletResponse response) {

        LobHandler lobHandler = new DefaultLobHandler();
        OutputStream out = null;

        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String query = "select s_file from s_folders where s_id = ? and s_owner_id = ?";

            final OutputStream finalOut = out;

            getJdbcTemplate().query(query, new AbstractLobStreamingResultSetExtractor() {
                protected void handleNoRowFound() throws LobRetrievalFailureException {
                    throw new IncorrectResultSizeDataAccessException("Ошибка при чтении файла из базы", 1, 0);
                }

                public void streamData(ResultSet rs) throws SQLException, IOException {
                    InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                    if (is != null) {
                        FileCopyUtils.copy(is, finalOut);
                    }
                }
            }, id, userId);


        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public String getFileInJson (long id, String userId) {

        LobHandler lobHandler = new DefaultLobHandler();

        String result = null;

        try {
            String query = "select s_file from s_folders where s_id = ? and s_owner_id = ?";

            final String res3 = result;

            getJdbcTemplate().query(query, new AbstractLobStreamingResultSetExtractor() {
                protected void handleNoRowFound() throws LobRetrievalFailureException {
                    throw new IncorrectResultSizeDataAccessException("Ошибка при чтении файла из базы", 1, 0);
                }

                public void streamData(ResultSet rs) throws SQLException, IOException {
                    InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                    if (is != null) {
                        try {
                            System.out.println("объект не налл");
                            Workbook workbook = WorkbookFactory.create(is);
                            // Get the first Sheet.
                            Sheet sheet = workbook.getSheetAt( 0 );

                            // Start constructing JSON.
                            JSONObject json = new JSONObject();

                            // Iterate through the rows.
                            JSONArray rows = new JSONArray();
                            for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
                            {
                                Row row = rowsIT.next();
                                JSONObject jRow = new JSONObject();

                                // Iterate through the cells.
                                JSONArray cells = new JSONArray();
                                for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
                                {
                                    Cell cell = cellsIT.next();
                                    cells.add(cell.getStringCellValue());
                                }
                                jRow.put( "cell", cells );
                                rows.add(jRow);
                            }

                            // Create the JSON.
                            json.put( "rows", rows );

                            System.out.println("json.toString()=" + json.toString());

                            //res3 = json.toString();

                            String res2 = res3;
                            res2 = json.toString();

                        } catch (InvalidFormatException e) {
                            System.out.println("ошибка в WorkbookFactory");
                            e.printStackTrace();
                        }
                    }
                }
            }, id, userId);

        } catch(Exception e) {
            System.out.println("ошибка в запросе вроде как?");
            e.printStackTrace();
            return "";
        }

        return result;



    }






}