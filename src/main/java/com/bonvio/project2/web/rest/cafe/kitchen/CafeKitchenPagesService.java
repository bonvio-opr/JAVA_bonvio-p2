package com.bonvio.project2.web.rest.cafe.kitchen;

import com.bonvio.project2.dao.cafe.kitchen.implementation.CafeKitchenPagesDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersPagesDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Arti on 11.08.2014.
 */
@Controller
@RequestMapping("app_libkitchen")
public class CafeKitchenPagesService {

    @Autowired(required = true)
    public CafeKitchenPagesDaoImpl dao;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView autoredirect(HttpServletRequest request) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView model = new ModelAndView();

        try {
            if(session.getAttribute("kitchenId").toString().length() > 0) {
                model.setViewName("app_libkitchen/app_libkitchen");
                return model;
            }
        } catch(NullPointerException e) {
            System.out.println("Диагностика: попытка  неавторизованного входа.");
        }
        model.setViewName("app_libkitchen/login");
        return model;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView goLogin() {
        return new ModelAndView("app_libkitchen/login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView goLogout() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        session.setAttribute("userId", null);
//        session.setAttribute("userPhoneNumber", null);
//        session.setAttribute("kitchenId", null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app_libkitchen/login");
        return modelAndView;
    }

    @RequestMapping(value="/loginfailedp", method=RequestMethod.GET)
    public ModelAndView goLoginError(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.addObject("loginError", "Введенные данные неточны");
        model.setViewName("app_libkitchen/login");
        return model;
    }

    @RequestMapping(value="/check", method = RequestMethod.POST)
    public ModelAndView goCheck(@RequestParam("usrnum") String number, @RequestParam("usrpwd") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        try {
            String optimizedNumber = optimizeNumber(number);
            int checkResult = dao.checkCredentials(optimizedNumber, password);
//            int checkResult = 1; //permanent authentication (XXXX: remove it after the GUI will be ready)
            if (checkResult == 1) {
                session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
                session.setAttribute("kitchenId", optimizeNumber(number));
                model.setViewName("app_libkitchen/app_libkitchen");
                model.addObject("libfullinfo", dao.getCafeKitchenObjectInfo("127.0.0.1"));
                return model;
            } else if (checkResult == 2) {
                model.addObject("loginError", "Неверно указан пароль <a>(восстановление пароля)</a>");
                model.setViewName("app_libkitchen/login");
                return model;
            } else if (checkResult == 3) {
                model.addObject("lib_spot_freeTables", dao.getFreeTablesArray("127.0.0.1"));
                model.setViewName("app_libkitchen/login");
                return model;
            } else if (checkResult == 4) {
                model.addObject("lastconfirmationnum", optimizedNumber);
                model.addObject("lastconfirmationdate", new java.util.Date());
                model.setViewName("app_libkitchen/confirm");
                return model;
            } else if (checkResult == 5) {
                session.setAttribute("error", "Ошибка SMS-сервера, попробуйте позже");
                model.addObject("lib_spot_freeTables", dao.getFreeTablesArray("127.0.0.1"));
                model.setViewName("app_libkitchen/login");
                return model;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("page: (ERROR) logout");
            model.addObject("lib_spot_freeTables", dao.getFreeTablesArray("127.0.0.1"));
        }
        model.setViewName("app_libkitchen/login");
        return model;
    }

    @RequestMapping(value="/app_libkitchen", method = RequestMethod.GET)
    public ModelAndView goCafe(HttpServletRequest request) {
        HttpSession session;
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
            session.setAttribute("userId", user.getUsername());
        }catch(Exception e) {
            System.out.println("page: (ERROR) logout");
            modelAndView.addObject("lib_spot_freeTables", dao.getFreeTablesArray("127.0.0.1"));
            modelAndView.setViewName("app_libkitchen/login");
            return modelAndView;
        }
        System.out.println("DEBUG:  Request= /cafep; workSessionId="+session.getId()+"; userid="+session.getAttribute("userid"));
//        modelAndView.addObject("cafefullinfo", dao.getCafeObject(request.getRemoteAddr()));
        modelAndView.addObject("libfullinfo", dao.getCafeKitchenObjectInfo("127.0.0.1"));
        modelAndView.setViewName("app_libkitchen/app_libkitchen");
        return modelAndView;
    }



    public String getSha1(String input) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private String optimizeNumber(String s) {
        //Переводит номер в необходимый формат вида ЖЖЖЖЖЖЖЖЖЖ, вместо +7(ЖЖЖ)ЖЖЖ-ЖЖ-ЖЖ
        s = s.replace("(", "").replace(")", "").replace("+7", "").replace(" ", "").replace("-", "");
        if (s.startsWith("8") && s.length() > 10)
            s = s.substring(1);
        return s;
    }

}
