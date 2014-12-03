package com.bonvio.project2.web.rest.cafe.barman;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanMenuDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Arti on 01.08.2014.
 */

@RestController
@RequestMapping("/app_libbarman/menu")
public class CafeBarmanMenuService {
    @Autowired
    public CafeBarmanMenuDaoImpl dao;

    @RequestMapping(value = "/getPosition", method = RequestMethod.POST)
    public String getCategoryNameByPositionIdAndSpotId(@RequestParam("pid") int pid, @RequestParam("sid") int spotId) {
        return dao.getCategoryNameByPositionMenuIdAndSpotId(pid, spotId);
    }

    @RequestMapping(value = "/getPosByCatId", method = RequestMethod.POST)
    public List<MenuPosition> getMenuPositionsByCategoryId(@RequestParam("cid") int cid) {
        return dao.getMenuPositionsByCategoryId(cid);
    }

    @RequestMapping(value = "/getPositionById", method = RequestMethod.POST)
    public MenuPosition getPositionById(@RequestParam("pid") int pid) {
        return dao.getPositionFullInfoByPositionId(pid);
    }
}
