package com.bonvio.project2.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by Arti Urskov on 16.04.14.
 */
public abstract class BaseDao extends NamedParameterJdbcDaoSupport {

    protected String defaultSchema = "ARTI";

    public BaseDao(DataSource dataSource) {
        setDataSource(dataSource);
    }
}