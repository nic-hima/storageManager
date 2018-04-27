package com.storagemanager.storagemanager.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


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
        for (Product iteration: productList) {
            System.out.println(iteration.toString());

        }
        model.addAttribute("listOfAllProducts", productRepository.findAll());
        model.addAttribute("product", new Product());
        model.addAttribute("deleteProduct", new Product());
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





    @PostMapping
    @Transactional
    public String createProduct(@ModelAttribute(name = "product") Product newProduct, @ModelAttribute(name = "deleteProduct") Product deleteProduct, Model model) {
        if (1==0)
        {
            String output = "Invalid Form";
            System.out.print("Validation errors while submitting form");
            model.addAttribute("message", output);
            return "notification";
        }
        System.out.print(newProduct.toString() + " saved successfully\n");
        productRepository.save(newProduct);
        System.out.println("Total number of saved products: " + productRepository.count());
        List<Product> productList = productRepository.findAll();
        model.addAttribute("listOfAllProducts", productRepository.findAll());
        model.addAttribute("product", new Product());
        /*Optional<Product> test = productRepository.findById((Long)newProduct.getSku());
        if(test.isPresent() ) {
            System.out.println("Product is present" + test.toString());
        }*/
        return "products";

   }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute(name = "deleteProduct") Product deleteProduct, @ModelAttribute(name = "product") Product newProduct, Model model) {
        String message;
        Optional<Product> test = productRepository.findById(deleteProduct.sku);
        if(test.isPresent() ) {
            System.out.println("Product is present" + test.toString());
            productRepository.deleteById(deleteProduct.sku);
            message = "Product of SKU: " + deleteProduct.sku + " was successfully deleted";
            model.addAttribute("message", message);
            return "products";
        }
        message = "Product of SKU: " + deleteProduct.sku + " was not found";
        model.addAttribute("message", message);
        return "products";

    }
}


