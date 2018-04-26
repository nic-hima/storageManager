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

    @GetMapping
    public String returnProducts(Model model)
    {
        List<Product> productList = productRepository.findAll();
        {
            System.out.println("list is empty");
        }
        //model.addAttribute("listOfAllProducts", productRepository.findAll());
        model.addAttribute("product", new Product());
        return "products";
    }


/*    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        System.out.println(name);

        if (name == "" || name == null)
        {
            name = "hello world";
        }

        model.addAttribute("message", name);
        return "notification";
    }*/





    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @Transactional
    public String createProduct(@ModelAttribute(name = "product") Product newProduct, Model model) {
        if (1==0)
        {
            String output = "Invalid Form";
            System.out.print("Validation errors while submitting form");
            model.addAttribute("message", output);
            return "notification";
        }
        System.out.print(newProduct.getName()+ " " + newProduct.getSku() + " " + newProduct.getDescription() + "saved successfully\n");
        productRepository.save((newProduct));
        return "products";

   }

}


