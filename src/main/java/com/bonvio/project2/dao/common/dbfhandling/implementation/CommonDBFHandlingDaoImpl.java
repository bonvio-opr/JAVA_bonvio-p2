package com.bonvio.project2.dao.common.dbfhandling.implementation;

import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.dbfhandling.CommonDBFHandlingDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Arti on 06.10.2014.
 */
public class CommonDBFHandlingDaoImpl extends BaseDao implements CommonDBFHandlingDao {

    @Autowired
    public CommonDBFHandlingDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


}
