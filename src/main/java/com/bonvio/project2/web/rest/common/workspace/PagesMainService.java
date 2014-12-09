package com.bonvio.project2.web.rest.common.workspace;

import com.bonvio.project2.classes.common.workspace.*;
import com.bonvio.project2.dao.common.workspace.implementation.PagesMainDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arti on 07.07.2014.
 */

@Controller
//@RestController
public class PagesMainService {

    @Autowired(required = true)
    public PagesMainDaoImpl dao;

    String error = null;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView autoredirect() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        ModelAndView modelAndView = new ModelAndView();
        try {
            if(session.getAttribute("userId").toString().length()>0) {
                modelAndView.addObject("error", error);
                error = null;
                modelAndView.setViewName("workspace/workspace");
                return modelAndView;
            }
        } catch(Exception ignored) {}
       // modelAndView.addObject("error", "Для продолжения введите данные своей учётной записи.");
        modelAndView.addObject("error", error);
        error = null;
        modelAndView.setViewName("workspace/login");
        return modelAndView;
    }

    @RequestMapping(value="/check", method = RequestMethod.POST)
    public String goCheck(@RequestParam("usrnum") String number, @RequestParam("usrpwd") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        try {
            if (session.getAttribute("userId").toString().length()*session.getAttribute("userPhoneNumber").toString().length() > 0) {
                return "redirect:/";
            }
        } catch (Exception e) {}
        try {
            String optimizedNumber = optimizeNumber(number);
            int checkResult = dao.checkCredentials(optimizedNumber, password);
            if (checkResult == 1) {
                Integer userId = dao.getUserIdByPhoneNumber(optimizedNumber);
                if(userId != 0) {
                    session.setAttribute("userId", userId);
                    session.setAttribute("userPhoneNumber", optimizeNumber(number));
                    model.setViewName("workspace/workspace");
                } else {
                    session.invalidate();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userPhoneNumber", optimizeNumber(number));
                    model.setViewName("workspace/login");
                }
                return "redirect:/";
            } else if (checkResult == 2) {
                //model.addObject("loginError", "Неверно указан пароль <a>(восстановление пароля)</a>");
                error = "Неверно указан номер телефона или пароль";
                model.setViewName("workspace/login");
                return "redirect:/";
            } else if (checkResult == 3) {
//                session.invalidate();
                //model.addObject("loginError", "Ваша учетная запись заблокирована.");
                error = "Ваша учетная запись заблокирована.";
                model.setViewName("workspace/login");
                return "redirect:/";
            } else if (checkResult == 4) {
                //model.addObject("lastconfirmationnum", optimizedNumber);
                //model.addObject("lastconfirmationdate", new java.util.Date());
                request.setAttribute("lastconfirmationnum", optimizedNumber);
                request.setAttribute("lastconfirmationdate", new java.util.Date());
                //model.setViewName("workspace/confirm");
                //return "redirect:/";
                return "workspace/confirm";
            } else if (checkResult == 5) {
                session.setAttribute("error", "Ошибка SMS-сервера, попробуйте позже");
                //model.addObject("freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                model.setViewName("workspace/login");
                return "redirect:/";
            }
        } catch (Exception e) {
            //return new ModelAndView("workspace/login");
            return "redirect:/";
        }
        //model.addObject("freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        model.setViewName("workspace/login");
        //return model;
        return "redirect:/";
    }


    /*@RequestMapping(value="/check", method = RequestMethod.POST)
    public ModelAndView goCheck(@RequestParam("usrnum") String number, @RequestParam("usrpwd") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView model = new ModelAndView();
        try {
            if (session.getAttribute("userId").toString().length()*session.getAttribute("userPhoneNumber").toString().length() > 0) {
                //Already authorized
                model.setViewName("workspace/workspace");
                return model;
            }
        } catch (Exception e) {}
        try {
            String optimizedNumber = optimizeNumber(number);
//            String sha = getSha1(password);
            int checkResult = dao.checkCredentials(optimizedNumber, password);
            if (checkResult == 1) {
                Integer userId = dao.getUserIdByPhoneNumber(optimizedNumber);
                if(userId != 0) {
                    session.setAttribute("userId", userId);
                    session.setAttribute("userPhoneNumber", optimizeNumber(number));
                    model.setViewName("workspace/workspace");
                } else {
                    session.invalidate();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userPhoneNumber", optimizeNumber(number));
                    model.setViewName("workspace/login");
                }
                return model;
            } else if (checkResult == 2) {
                model.addObject("loginError", "Неверно указан пароль <a>(восстановление пароля)</a>");
                model.setViewName("workspace/login");
                return model;
            } else if (checkResult == 3) {
//                session.invalidate();
                model.addObject("loginError", "Ваша учетная запись заблокирована.");
                model.setViewName("workspace/login");
                return model;
            } else if (checkResult == 4) {
                model.addObject("lastconfirmationnum", optimizedNumber);
                model.addObject("lastconfirmationdate", new java.util.Date());
                model.setViewName("workspace/confirm");
                return model;
            } else if (checkResult == 5) {
                session.setAttribute("error", "Ошибка SMS-сервера, попробуйте позже");
                //model.addObject("freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
                model.setViewName("workspace/login");
                return model;
            }
        } catch (Exception e) {
            return new ModelAndView("workspace/login");
        }
        //model.addObject("freeTables", dao.getFreeTablesArray(request.getRemoteAddr()));
        model.setViewName("workspace/login");
        return model;
    }*/

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "workspace/login";
    }



    @RequestMapping(value="/loginfailed", method=RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("loginError", "Введенные данные неточны");
        return "workspace/login";
    }

    @RequestMapping(value="/updateApplicationPosition", method=RequestMethod.POST)
         @ResponseBody
         public int updateApplicationPosition (@RequestBody Application application) {
        return dao.updateApplicationPosition(application);
    }


    @RequestMapping(value="/imageview", method = RequestMethod.GET)
    public String imageView() {
        return "workspace/imageview";
    }


    @RequestMapping(value="/getwindow/{unitId}", method=RequestMethod.POST)
    @ResponseBody
    public Window getWindow (@PathVariable("unitId") int unitId) {
        System.out.println("НЛО прилетело");

        return dao.getWindow(unitId);
    }

    @RequestMapping(value="/updatewindow", method=RequestMethod.POST)
    @ResponseBody
    public int updateWindow (@RequestBody Window window) {
        return dao.updateWindow(window);
    }

    @RequestMapping(value="/deletewindow", method=RequestMethod.POST)
    @ResponseBody
    public int deleteWindow (@RequestBody Window window) {
        return dao.deleteWindow(window);
    }



    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("userId", null);
        session.setAttribute("userPhoneNumber", null);
/*        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workspace/login");
        return modelAndView;*/
        return "redirect:/";
    }

    /*@RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("userId", null);
        session.setAttribute("userPhoneNumber", null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workspace/login");
        return modelAndView;
    }*/

    @RequestMapping(value="/proceed", method = RequestMethod.POST)
    public ModelAndView goProceed(@RequestParam("lnum") String number, @RequestParam("lcode") String code, HttpServletRequest request, Model mdl) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lastconfirmationnum", number);
        if(dao.checkConfirmationCode(number, code)==0) {
            modelAndView.addObject("lasterror", "Неверный код");
            modelAndView.addObject("lastconfirmationdate", new java.util.Date());
            modelAndView.setViewName("workspace/confirm");
        } else {
            dao.insertUser(number);
            modelAndView.addObject("lasterror", null);
            HttpSession session = request.getSession();
            Integer userId = dao.getUserIdByPhoneNumber(number);
            session.setAttribute("userId", userId);
            session.setAttribute("userPhoneNumber", optimizeNumber(number));
            modelAndView.setViewName("workspace/workspace");
        }
        return modelAndView;
    }
    //old
    @RequestMapping(value = "/getCurrentUserPrivateWorkspace", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<WorkspaceWithApplications> getPrivateWorkspace(HttpServletRequest request) {
        String userId, userPhoneNumber;
        try {
            userId=request.getSession().getAttribute("userId").toString();
            userPhoneNumber=request.getSession().getAttribute("userPhoneNumber").toString();
            return dao.getUserPrivateWorkspace(userId, userPhoneNumber);
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }


    @RequestMapping(value = "/getWorkspaces", method = RequestMethod.GET)
    @ResponseBody
    public List <WorkspaceApplicationsWithType> getWorkspaces(HttpServletRequest request) {
        String userId;
        try {
            userId= request.getSession().getAttribute("userId").toString();
            return dao.getWorkspaces(userId);
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }


    @RequestMapping(value = "/getApplicationsById/{idApp}", method = RequestMethod.GET)
    @ResponseBody
    public List <Application> getApplicationsByIdp(@PathVariable (value = "idApp") String idApp, HttpServletRequest request) {

        //input typeApp and idApp

        String wsType = idApp.substring(0, 1);
        idApp = idApp.substring(1);
        String userId;

        if (wsType.equals("p")){
            try {
                userId= request.getSession().getAttribute("userId").toString();
                return dao.getPrivateApplications(idApp, userId);
            } catch (Exception e) {e.printStackTrace();}
        }

        if (wsType.equals("a")){
            try {
                userId= request.getSession().getAttribute("userId").toString();
                return dao.getAdditionalApplications(idApp, userId);
            } catch (Exception e) {e.printStackTrace();}
        }

        return null;
    }

    @RequestMapping(value = "/getWindowsById/{idWs}", method = RequestMethod.GET)
    @ResponseBody
    public List <Window> getWindowsById(@PathVariable (value = "idWs") String idWs, HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();

        String wsType = idWs.substring(0, 1);
        idWs = idWs.substring(1);
        System.out.println(wsType);

        if (wsType.equals("p")){
            try {
                return dao.getWindowByWsId(idWs, userId);
            } catch (Exception e) {e.printStackTrace();}
        }

        return null;
    }




    /*@RequestMapping(value = "/getApplicationsById/a/{idApp}", method = RequestMethod.GET)
    @ResponseBody
    public List <Application> getApplicationsByIda(@PathVariable (value = "idApp") String idApp, HttpServletRequest request) {
        String userId;
        try {
            userId= request.getSession().getAttribute("userId").toString();
            return dao.getAdditionalApplications(idApp, userId);
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }*/





    //old
    @RequestMapping(value = "/getCurrentUserAdditionalWorkspaces", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<WorkspaceWithApplications> getUserAdditionalWorkspaces(HttpServletRequest request) {
        String userId, userPhoneNumber;
        try {
            userId=request.getSession().getAttribute("userId").toString();
            userPhoneNumber=request.getSession().getAttribute("userPhoneNumber").toString();
            return dao.getUserAdditionalWorkspaces(userId, userPhoneNumber);
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }

    @RequestMapping(value="/getCurrentUserCredentials", method = RequestMethod.GET)
    public @ResponseBody
    UserCredentials getCurrentUserCredentials() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        try {
            return dao.getCurrentUserCredentials(session.getAttribute("userId").toString(), session.getAttribute("userPhoneNumber").toString());
        } catch (Exception e) {
            System.out.println("ERROR: can't get current user credentials");
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value="/getUserUnitAccessRights/{wsId}/{unitCode}/", method = RequestMethod.GET)
    public @ResponseBody int getUserUnitAccessRights(
            @PathVariable("wsId") int wsId,
            @PathVariable("unitCode") String unitCode
    ) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        try {
            String userId = session.getAttribute("userId").toString();
            return dao.getUserUnitAccessRights(wsId, unitCode, userId);
        } catch (Exception e) {
            System.err.println("ERROR: unknown error OR security attack: attempt to execute not owned application; ");
            return 0;
        }
    }


    private String optimizeNumber(String s) {
        //Переводит номер в необходимый формат вида ЖЖЖЖЖЖЖЖЖЖ, вместо +7(ЖЖЖ)ЖЖЖ-ЖЖ-ЖЖ
        s = s.replace("(", "")
            .replace(")", "")
            .replace("+7", "")
            .replace(" ", "")
            .replace("-", "");
        if (s.startsWith("8") && s.length() > 10)
            s = s.substring(1);
        return s;
    }

}
