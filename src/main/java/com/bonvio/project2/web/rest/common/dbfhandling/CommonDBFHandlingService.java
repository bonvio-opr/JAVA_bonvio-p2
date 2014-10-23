package com.bonvio.project2.web.rest.common.dbfhandling;

import com.bonvio.project2.dao.common.dbfhandling.implementation.CommonDBFHandlingDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Arti on 06.10.2014.
 */
public class CommonDBFHandlingService {

    @Autowired
    public CommonDBFHandlingDaoImpl dao;

}
