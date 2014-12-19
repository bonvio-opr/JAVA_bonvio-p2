package com.bonvio.project2.web.rest.cafe.clients;

import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsPagesDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * Created by Arti on 19.06.2014.
 */

@Controller
//@RequestMapping("cafe")
@RequestMapping("/app_libclients")
public class CafeClientsPagesService {

    @Autowired(required = true)
    public CafeClientsPagesDaoImpl dao;

    /*@RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView autoredirect(HttpServletRequest request) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView modelAndView = new ModelAndView();
        try {
            if(session.getAttribute("userId").toString().length()*session.getAttribute("userPhoneNumber").toString().length() > 0) {
                modelAndView.addObject("libfullinfo", groupsManagement.getCafeObject("127.0.0.1"));
                modelAndView.setViewName("app_libclients/app_libclients");
                return modelAndView;
            }
        } catch(Exception e) {
            e.printStackTrace();
            session.setAttribute("userId", null);
            session.setAttribute("userPhoneNumber", null);
            modelAndView.setViewName("app_libclients/login");
            modelAndView.addObject("lib_spot_freeTables", groupsManagement.getFreeTablesArray("127.0.0.1"));
            return modelAndView;
        }
        modelAndView.addObject("lib_spot_freeTables", groupsManagement.getFreeTablesArray("127.0.0.1"));
        modelAndView.addObject("loginError", "Зафиксирована попытка доступа к недоступному приложению");
        session.setAttribute("userId", null);
        session.setAttribute("userPhoneNumber", null);
        modelAndView.setViewName("app_libclients/login");
        return modelAndView;
    }*/

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView autoredirect(HttpServletRequest request) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView modelAndView = new ModelAndView();
        try {
            if(session.getAttribute("cafeUserId").toString().length()*session.getAttribute("cafeUserPhoneNumber").toString().length() > 0) {
                modelAndView.addObject("libfullinfo", dao.getCafeObject(request.getRemoteAddr()));
                modelAndView.setViewName("app_libclients/app_libclients");
                return modelAndView;
            }
        } catch(Exception e) {
            session.setAttribute("cafeUserId", null);
            session.setAttribute("cafeUserPhoneNumber", null);
            modelAndView.setViewName("app_libclients/login");
            modelAndView.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
            return modelAndView;
        }
        modelAndView.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        modelAndView.addObject("loginError", "Зафиксирована попытка доступа к недоступному приложению");
        session.setAttribute("cafeUserId", null);
        session.setAttribute("cafeUserPhoneNumber", null);
        modelAndView.setViewName("app_libclients/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView goLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView goLogout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("cafeUserId", null);
        session.setAttribute("cafeUserPhoneNumber", null);
        System.out.println("DEBUG:  Request= /logout; workSessionId="+session.getId()+"; SESSION WAS INVALIDATED; ");
        modelAndView.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        modelAndView.setViewName("app_libclients/login");
        return modelAndView;
    }

    @RequestMapping(value="/loginfailedp", method=RequestMethod.GET)
    public ModelAndView goLoginError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().invalidate();
        modelAndView.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        modelAndView.setViewName("app_libclients/login");
        return modelAndView;
    }

    @RequestMapping(value="/check", method = RequestMethod.POST)
    public ModelAndView goCheck(@RequestParam("usrnum") String number, @RequestParam("usrpwd") String password, @RequestParam("usrtable") Integer table, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        try {
            if (session.getAttribute("cafeUserId").toString().length()*session.getAttribute("cafeUserPhoneNumber").toString().length() > 0) {
                //Already authorized
                model.setViewName("app_libclients/app_libclients");
                model.addObject("lib_tbl_num", table);
                session.setAttribute("userTableNum", table);
//                model.addObject("libfullinfo", groupsManagement.getCafeObject(request.getRemoteAddr()));
                model.addObject("libfullinfo", dao.getCafeObject(request.getRemoteAddr()));
                return model;
            }
        } catch (Exception e) {}
        try {
                String optimizedNumber = optimizeNumber(number);
                int checkResult = dao.checkCredentials(optimizedNumber, password);
                if (checkResult == 1) {
                    session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
                    Integer userId = dao.getUserIdByPhoneNumber(optimizedNumber);
                    if(userId != 0) {
                        session.setAttribute("cafeUserId", userId);
                        session.setAttribute("cafeUserPhoneNumber", optimizeNumber(number));
                        model.setViewName("app_libclients/app_libclients");
                        model.addObject("userTableNum", table);
                        session.setAttribute("userTableNum", table);
                        model.addObject("libfullinfo", dao.getCafeObject(request.getRemoteAddr()));
                    } else {
                        session.setAttribute("cafeUserId", null);
                        session.setAttribute("cafeUserPhoneNumber", null);
                        model.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                        model.setViewName("workspace/login");
                    }
                    return model;
                } else if (checkResult == 2) {
                    model.addObject("loginError", "Неверно указан пароль <a>(восстановление пароля)</a>");
                    model.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                    model.setViewName("app_libclients/login");
                    return model;
                } else if (checkResult == 3) {
                    model.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                    model.addObject("loginError", "Ваша учетная запись заблокирована.");
                    model.setViewName("app_libclients/login");
                    return model;
                } else if (checkResult == 4) {
                    model.addObject("lastconfirmationnum", optimizedNumber);
                    model.addObject("lastconfirmationdate", new java.util.Date());
                    session.setAttribute("lib_tbl_num", table);
                    model.setViewName("app_libclients/confirm");
                    return model;
                } else if (checkResult == 5) {
                    session.setAttribute("loginError", "Ошибка SMS-сервера, попробуйте позже");
                    model.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                    model.addObject("lib_tbl_num", table);
                    model.setViewName("app_libclients/login");
                    return model;
                }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("page: (ERROR) logout");
            return new ModelAndView("app_libclients/login");
        }
        model.addObject("lib_spot_freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        model.setViewName("app_libclients/login");
        return model;
    }

    @RequestMapping(value="/proceed", method = RequestMethod.POST)
    public ModelAndView goProceed(@RequestParam("lnum") String number, @RequestParam("lcode") String code, HttpServletRequest request, Model mdl) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lastconfirmationnum", number);
        if(dao.checkConfirmationCode(number, code)==0) {
            modelAndView.addObject("lasterror", "Неверный код");
            modelAndView.addObject("lastconfirmationdate", new java.util.Date());
//            modelAndView.setViewName("cafe/confirm");
            modelAndView.setViewName("app_libclients/confirm");
        } else {
            dao.insertUser(number);
            modelAndView.addObject("lasterror", null);
            HttpSession session = request.getSession();
            Integer userId = dao.getUserIdByPhoneNumber(number);
            session.setAttribute("cafeUserId", userId);
            session.setAttribute("cafeUserPhoneNumber", optimizeNumber(number));
            modelAndView.addObject("libfullinfo", dao.getCafeObject(request.getRemoteAddr()));
            modelAndView.setViewName("app_libclients/app_libclients");
        }
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
