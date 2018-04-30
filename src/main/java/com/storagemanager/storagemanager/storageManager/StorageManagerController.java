package com.storagemanager.storagemanager.storageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NHima on 4/24/18.
 */

@Controller

public class StorageManagerController {

    //@Autowired
    //StorageManagerRepository storageManagerRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm(Model model)
    {
        model.addAttribute("message", "Storage Manager Login");
        return "loginForm";
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    public String loginSubmit(HttpServletRequest request, Model model)
    {
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        String response;
        if(username == "") {
            response = "No username";
            model.addAttribute("message", response);
            return "loginForm";
        }
        if(password == "") {
            response = "No password";
            model.addAttribute("message", response);
            return "loginForm";
        }
        return "portalLanding";
    }

    @RequestMapping(value = "/landing", method = RequestMethod.GET)
    public String gotoLanding(Model model)
    {
        System.out.println("hello");
        return "portalLanding";
    }
}