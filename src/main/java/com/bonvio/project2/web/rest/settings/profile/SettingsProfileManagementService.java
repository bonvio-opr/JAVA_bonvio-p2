package com.bonvio.project2.web.rest.settings.profile;

import com.bonvio.project2.classes.settings.profile.FullUserProfile;
import com.bonvio.project2.dao.settings.profile.implementation.SettingsProfileManagementDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arti on 07.10.2014.
 */

@RestController
@RequestMapping("settings/profile")
public class SettingsProfileManagementService {

    @Autowired
    public SettingsProfileManagementDaoImpl dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loadProfilePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workspace/profile");
        return modelAndView;
    }



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
    public int refreshMyFullUserProfile(@RequestBody FullUserProfile profile, HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            String userPhone = request.getSession().getAttribute("userPhoneNumber").toString();
            if(dao.refreshMyFullUserProfile(userId, userPhone, profile) == 1) {
                request.getSession().setAttribute("userPhoneNumber", profile.getProfilePhoneNumber());
                return 1;
            } else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value = "/refreshUserPassAndPhone", method = RequestMethod.POST)
    public int refreshUserPassAndPhone(@RequestBody FullUserProfile profile, HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            //String userPhone = request.getSession().getAttribute("userPhoneNumber").toString();
            if(dao.refreshUserPassAndPhone(userId, profile) == 1) {
                request.getSession().setAttribute("userPhoneNumber", profile.getProfilePhoneNumber());
                return 1;
            } else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value = "/refreshUserImage", method = RequestMethod.POST)
    public int refreshUserImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("userId").toString();
            dao.addImage(userId, file);
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}