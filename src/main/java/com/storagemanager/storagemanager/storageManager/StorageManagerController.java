package com.storagemanager.storagemanager.storageManager;

import com.storagemanager.storagemanager.product.Product;
import com.storagemanager.storagemanager.product.ProductRepository;
import com.storagemanager.storagemanager.productBatch.ProductBatchEntry;
import com.storagemanager.storagemanager.productBatch.ProductBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by NHima on 4/24/18.
 */

@Controller

public class StorageManagerController {

    @Autowired
    StorageManagerRepository storageManagerRepository;

    @Autowired
    ProductBatchRepository productBatchRepository;

    @Autowired
    ProductRepository productRepository;

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
        List<ProductBatchEntry> allBE = new ArrayList<ProductBatchEntry>();
        List<Product> allP = new ArrayList<Product>();
        allBE = productBatchRepository.findAll();
        allP = productRepository.findAll();

        Calendar now =Calendar.getInstance();
        Calendar check =Calendar.getInstance();
        System.out.println(now.getTime());
        List<ProductBatchEntry> warning = new ArrayList<ProductBatchEntry>();
        List<ProductBatchEntry> quantity = new ArrayList<ProductBatchEntry>();
        if(!(allBE.isEmpty())) {
            for (ProductBatchEntry current : allBE) {
                List<Product> tempP = productRepository.findBysku(current.getProductSku());
                Product l = tempP.get(0);
                if (l.isPerishable()) {
                    check.setTime(current.getDateReceived());
                    System.out.println(current.getName() + " was received " + check.getTime());
                    check.add(Calendar.DATE, 5);
                    System.out.println(current.getName() + " should have a warning on " + check.getTime());
                    if (now.getTime().compareTo(check.getTime()) > 0) {
                        System.out.println("Add to List");
                        check.add(Calendar.DATE, 2);
                        current.setDateReceived(check.getTime());
                        warning.add(current);
                    }

                }
            }
        }
        if(!(allP.isEmpty())) {
            for (Product current : allP) {
                List<ProductBatchEntry> tempBE = productBatchRepository.findByproductSku(current.getSku());
                int iQuantity = 0;
                if (!tempBE.isEmpty()) {
                    for (ProductBatchEntry curr : tempBE) {
                        iQuantity = curr.getQuantity();
                    }
                    if (iQuantity <= 5) {
                        List<ProductBatchEntry> qLow = productBatchRepository.findByproductSku(current.getSku());
                        ProductBatchEntry l = qLow.get(0);
                        l.setQuantity(iQuantity);
                        quantity.add(l);
                    }
                }
            }
        }

        model.addAttribute("listOfAllLowProductBatch", quantity);
        model.addAttribute("listOfAllExpiringProductBatch", warning);
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