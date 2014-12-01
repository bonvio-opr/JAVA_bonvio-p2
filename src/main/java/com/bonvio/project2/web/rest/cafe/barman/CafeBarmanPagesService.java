package com.bonvio.project2.web.rest.cafe.barman;

import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanPagesDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersPagesDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Arti on 30.07.2014.
 */
@Controller
@RequestMapping("app_libbarman")
public class CafeBarmanPagesService {

    @Autowired(required = true)
    public CafeBarmanPagesDaoImpl dao;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView autoredirect(HttpServletRequest request) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView m = new ModelAndView();
        m.setViewName("app_libbarman/app_libbarman");
        return m;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView goLogin() {
        return new ModelAndView("app_libbarman/login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String goLogout() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        session.setAttribute("barmanId", null);
//        session.invalidate();
        return "app_libbarman/login";
    }

    @RequestMapping(value="/loginfailedp", method=RequestMethod.GET)
    public String goLoginError(HttpServletRequest request) {
//        request.getSession().invalidate();
        return "app_libbarman/login";
    }

    @RequestMapping(value="/check", method = RequestMethod.POST)
    public ModelAndView goCheck(@RequestParam("usrnum") String number, @RequestParam("usrpwd") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        try {
            String optimizedNumber = optimizeNumber(number);
//            String sha = getSha1(password);
            int checkResult = dao.checkCredentials(optimizedNumber, password);
            if (checkResult == 1) {
                session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
                session.setAttribute("barmanId", optimizeNumber(number));
                model.setViewName("app_libbarman/app_libbarman");
                model.addObject("cafefullinfo", dao.getCafeObject("127.0.0.1"));
                return model;
            } else if (checkResult == 2) {
                model.setViewName("app_libbarman/login");
                return model;
            } else if (checkResult == 3) {
                model.setViewName("app_libbarman/login");
                return model;
            } else if (checkResult == 4) {
                model.addObject("lastconfirmationnum", optimizedNumber);
                model.addObject("lastconfirmationdate", new java.util.Date());
                model.setViewName("libbrm/confirm");
                return model;
            } else if (checkResult == 5) {
                session.setAttribute("error", "Ошибка SMS-сервера, попробуйте позже");
                model.setViewName("libbrm/login");
                return model;
            }
        } catch (Exception e) {
            return new ModelAndView("app_libbarman/login");
        }
        model.setViewName("app_libbarman/login");
        return model;
    }

    @RequestMapping(value="app_libbarman/app_libbarman", method = RequestMethod.GET)
    public ModelAndView goCafe(HttpServletRequest request) {
        HttpSession session;
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
            session.setAttribute("userid", user.getUsername());
        }catch(Exception e) {
            return new ModelAndView("app_libbarman/login");
        }
//        modelAndView.addObject("cafefullinfo", dao.getCafeObject(request.getRemoteAddr()));
        modelAndView.addObject("libfullinfo", dao.getCafeObject("127.0.0.1"));
        modelAndView.setViewName("app_libbarman/app_libbarman");
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

    //============================== out pages ===============================

    @RequestMapping(value = "/admin_page", method = RequestMethod.GET)
    public ModelAndView goPage_admin() {
        return new ModelAndView("app_libbarman/admin_page");
    }

    @RequestMapping(value = "/order_page", method = RequestMethod.GET)
    public ModelAndView goPage_order() {
        return new ModelAndView("app_libbarman/order_page");
    }

    @RequestMapping(value = "/orderById_page", method = RequestMethod.GET)
    public ModelAndView goPage_orderById() {
        return new ModelAndView("app_libbarman/orderById_page");
    }

    @RequestMapping(value = "/message_page", method = RequestMethod.GET)
    public ModelAndView goPage_message() {
        return new ModelAndView("app_libbarman/message_page");
    }

    @RequestMapping(value = "/messageById_page", method = RequestMethod.GET)
    public ModelAndView goPage_messageById() {
        return new ModelAndView("app_libbarman/messageById_page");
    }

    @RequestMapping(value = "/kitchen_page", method = RequestMethod.GET)
    public ModelAndView goPage_kitchen() {
        return new ModelAndView("app_libbarman/kitchen_page");
    }

    @RequestMapping(value = "/bar_page", method = RequestMethod.GET)
    public ModelAndView goPage_bar() {
        return new ModelAndView("app_libbarman/bar_page");
    }

    @RequestMapping(value = "/createOrder_page", method = RequestMethod.GET)
    public ModelAndView goPage_createOrder() {
        return new ModelAndView("app_libbarman/createOrder_page");
    }

}
