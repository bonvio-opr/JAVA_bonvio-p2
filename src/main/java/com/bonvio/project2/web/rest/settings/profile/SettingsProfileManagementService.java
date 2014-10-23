package com.bonvio.project2.web.rest.settings.profile;

import com.bonvio.project2.classes.settings.profile.FullUserProfile;
import com.bonvio.project2.dao.settings.profile.implementation.SettingsProfileManagementDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arti on 07.10.2014.
 */

@RestController
@RequestMapping("settings/profile")
public class SettingsProfileManagementService {

    @Autowired
    public SettingsProfileManagementDaoImpl dao;

    @RequestMapping(value = "/getProfile", method = RequestMethod.POST)
    public FullUserProfile getMyFullUserProfile(HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            String userPhone = request.getSession().getAttribute("userPhoneNumber").toString();
            return dao.getMyFullUserProfile(userId, userPhone);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/refreshProfile", method = RequestMethod.POST)
    public int refreshMyFullUserProfile(FullUserProfile f, HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            String userPhone = request.getSession().getAttribute("userPhoneNumber").toString();
            if(dao.refreshMyFullUserProfile(userId, userPhone, f) == 1) {
                request.getSession().setAttribute("userPhoneNumber", f.getProfilePhoneNumber());
                return 1;
            } else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}