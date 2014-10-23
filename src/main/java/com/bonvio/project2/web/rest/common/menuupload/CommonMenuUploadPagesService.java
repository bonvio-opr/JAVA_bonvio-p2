package com.bonvio.project2.web.rest.common.menuupload;

import com.bonvio.project2.dao.common.menuupload.CommonMenuUploadPagesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Arti on 12.08.2014.
 */

@RestController
@RequestMapping("app_libmenuupload")
public class CommonMenuUploadPagesService {
    @Autowired
    public CommonMenuUploadPagesDao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView autoredirect(HttpServletRequest request) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app_libmenuupload/app_libmenuupload");
        return modelAndView;
    }

}
