package com.bonvio.project2.web.rest.cafe.clients;

import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Arti on 19.06.2014.
 */

@Controller
@RequestMapping("/app_libclients/user")
//@RequestMapping("/cafe/user")
public class CafeClientsUserService {

    @Autowired(required = true)
    public CafeClientsUserDaoImpl dao;

}