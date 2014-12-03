package com.bonvio.project2.dao.cafe.clients.implementation;

import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.clients.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Arti on 19.06.2014.
 */
public class CafeClientsUserDaoImpl extends BaseDao implements UserDao {
    @Autowired
    public CafeClientsUserDaoImpl(DataSource dataSource) {super(dataSource);}


}
