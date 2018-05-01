package com.storagemanager.storagemanager.storageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by NHima on 4/24/18.
 */

@Controller

public class StorageManagerController {

    @Autowired
    StorageManagerRepository storageManagerRepository;

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
        Optional<StorageManager> test = storageManagerRepository.findTestByusername(username);
        if(test.isPresent()) {
            System.out.println("User is present" + test.toString());
            List<StorageManager> temp = storageManagerRepository.findByusername(username);
            StorageManager l = temp.get(0);
            if(Objects.equals(username, l.getUsername()))
            {
                return "redirect:/landing";
            }
            else
            {
                response = "Valid username, invalid password";
                model.addAttribute("message", response);
                return "loginForm";
            }
        }
        else
        {
            response = "Invalid username";
            model.addAttribute("message", response);
            return "loginForm";
        }


    }

    @RequestMapping(value = "/landing", method = RequestMethod.GET)
    public String gotoLanding(Model model)
    {
        System.out.println("hello");
        return "portalLanding";
    }

    @RequestMapping(value = "/+u/{uName}/{pw}", method = RequestMethod.GET)
    public String addManager(@PathVariable String uName, @PathVariable String pw, Model model){
        StorageManager t = new StorageManager();
        t.setUsername(uName);
        t.setPassword(pw);
        storageManagerRepository.save(t);
        List<StorageManager> temp = storageManagerRepository.findAll();
        for (StorageManager curr : temp
             ) {
            System.out.println(curr.toString());
        }
        return "portalLanding";
    }
}