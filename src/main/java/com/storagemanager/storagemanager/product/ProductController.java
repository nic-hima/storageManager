package com.storagemanager.storagemanager.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by NHima on 4/20/18.
 * Controller for all methods using product Object
 */

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");

        if (name == null)
        {
            name = "hello world";
        }

        model.addAttribute("message", name);
        return "hello";
    }


}
/*

   //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("/new")
   //@ResponseStatus(HttpStatus.OK)
   //@Transactional
    public ModelAndView createProduct(@Valid Product newProduct, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors())
        {
            System.out.print("Validation errors while submitting form");
            modelAndView.setViewName("new");
            modelAndView.addObject("newProduct", newProduct);
            return modelAndView;
        }
        System.out.print(newProduct.getName()+ " " + newProduct.getSku() + " " + newProduct.getDescription() + "saved successfully\n");
        productRepository.save((newProduct));
        modelAndView.setViewName("index.html");
        return modelAndView;

   }

*/


