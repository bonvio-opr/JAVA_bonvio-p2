package com.bonvio.project2.web.rest.common.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.Test2;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivan on 11.12.2014.
 */

@Controller
@RequestMapping(value = "/computer")
public class UserCompConnection {

    private static String key = "qazwsxedyqqazwsxed";


    @RequestMapping(value = "/getsecret", method = RequestMethod.GET)
    @ResponseBody
    public String getSecret() {
        Test2 test2 = new Test2();

        String result = test2.encodeString("0011223344556677", "qazwsxedyqqazwsxed");

        System.out.println("Получили getsecret и отправили = " + result);

        return result;
    }


    @RequestMapping(value = "/getcmd", method = RequestMethod.GET)
    @ResponseBody
    public String getCmd(HttpServletRequest request) {

        String query = request.getParameter("secret").toLowerCase();

        System.out.println("получили getcmd = " + query);

        Test2 test2 = new Test2();

        String result = test2.decodeString(query, key);

        char[] chars = result.toCharArray();

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        String checkWord = "checkword:" + hex.toString() + ";cmd:none";

        System.out.println("Отдали getcmd, query=" + query + ",result=" + result);


        return checkWord;
    }


}
