package com.bonvio.project2.web.rest.common.workspace;

import com.bonvio.project2.classes.common.workspace.Folder;
import com.bonvio.project2.dao.common.workspace.implementation.FileManagerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 01.12.2014.
 */
@Controller
@RequestMapping(value="/filemanager")
public class FileManagerController {

    @Autowired
    FileManagerDaoImpl fileManagerDao;

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView returnJsp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workspace/filemanager");
        return modelAndView;
    }

    @RequestMapping(method= RequestMethod.POST, value = "/addfolder")
    @ResponseBody
    public long addFolder(@RequestBody Folder folder, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();

        return fileManagerDao.addFolder(folder, userId);
    }


    @RequestMapping(value = "/getfolderbyparentid/{parentid}",  method = RequestMethod.GET)
    @ResponseBody
    public List<Folder> getfolderbyparentiid(@PathVariable("parentid") long parentid, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        List <Folder> folders = fileManagerDao.getFolderByParentId(parentid, userId);

        return folders;
    }

    @RequestMapping(value = "/deletefolder/{folderId}",  method = RequestMethod.GET)
    @ResponseBody
    public int deleteFolder (@PathVariable("folderId") long folderId, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        fileManagerDao.deleteFolder(folderId, userId);
        return 0;
    }

    @RequestMapping(value = "/updatefolder",  method = RequestMethod.POST)
    @ResponseBody
    public int updateFolder (@RequestBody Folder folder, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        fileManagerDao.updateFolder(folder, userId);
        return 0;
    }

    //working with files

    @RequestMapping(value = "/uploadfile/{parentId}",  method = RequestMethod.POST)
    @ResponseBody
    public int uploadFile (@PathVariable("parentId") long parentId, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        fileManagerDao.uploadFile(file,parentId,  userId);
        return 0;
    }

    @RequestMapping(value = "/updatefile/{fileId}",  method = RequestMethod.POST)
    @ResponseBody
    public int updateFile (@PathVariable("fileId") long fileId, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        fileManagerDao.updateFile(file, fileId, userId);
        return 0;
    }

    @RequestMapping(value = "/getfile/{fileId}",  method = RequestMethod.GET)
    @ResponseBody
    public int getFile (@PathVariable("fileId") long fileId, HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getSession().getAttribute("userId").toString();
        fileManagerDao.getFile(fileId, userId, response);
        return 0;
    }

    @RequestMapping(value = "/getfilejson/{fileId}",  method = RequestMethod.GET)
    @ResponseBody
    public String getFile (@PathVariable("fileId") long fileId, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        return fileManagerDao.getFileInJson(fileId, userId);
    }
}
