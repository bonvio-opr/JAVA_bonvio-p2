package com.bonvio.project2.dao.common.workspace.implementation;

import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.workspace.UsersMainDao;

import javax.sql.DataSource;

/**
 * Created by Arti on 07.07.2014.
 */
public class UsersMainDaoImpl extends BaseDao implements UsersMainDao {

    public UsersMainDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


}
