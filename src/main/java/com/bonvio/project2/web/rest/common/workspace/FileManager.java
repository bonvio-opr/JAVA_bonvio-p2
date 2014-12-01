package com.bonvio.project2.web.rest.common.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Ivan on 01.12.2014.
 */
@Controller
@RequestMapping(value="/filemanager")
public class FileManager {

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView autoredirect() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("workspace/filemanager");
        return modelAndView;
    }





}
