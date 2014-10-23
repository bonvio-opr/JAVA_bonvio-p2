package com.bonvio.project2.dao.common.menuupload.implementation;

import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.menuupload.CommonMenuUploadPagesDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Arti on 12.08.2014.
 */
public class CommonMenuUploadPagesDaoImpl extends BaseDao implements CommonMenuUploadPagesDao {

    @Autowired
    public CommonMenuUploadPagesDaoImpl(DataSource dataSource) {
        super(dataSource);
    }
}
