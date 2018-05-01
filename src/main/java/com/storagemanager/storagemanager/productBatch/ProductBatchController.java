package com.storagemanager.storagemanager.productBatch;
import com.storagemanager.storagemanager.product.Product;
import com.storagemanager.storagemanager.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


/**
 * Created by NHima on 4/25/18.
 */
@Controller
@RequestMapping(value = "/productBatch")
public class ProductBatchController {

    @Autowired
    ProductBatchRepository productBatchRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String returnProductBatch(Model model)
    {
        List<ProductBatchEntry> productBatchList = productBatchRepository.findAll();
        for (ProductBatchEntry iteration: productBatchList) {
            System.out.println(iteration.toString());

        }
        model.addAttribute("listOfAllProductBatch", productBatchRepository.findAll());
        model.addAttribute("newProductBatch", new ProductBatchEntry());
        model.addAttribute("deleteProductBatch", new ProductBatchEntry());
        model.addAttribute("updateLocation", new ProductBatchEntry());
        model.addAttribute("updateQuantity", new ProductBatchEntry());

        return "productBatch";
    }

    @PostMapping
    @Transactional

    public String createProductBatch(@ModelAttribute(name = "newProductBatch") ProductBatchEntry newProductBatch,  Model model) {
        String message;
        System.out.println(newProductBatch.toString());
        if (1==0)
        {
            String output = "Invalid Form";
            System.out.print("Validation errors while submitting form");
            model.addAttribute("message", output);
            return "notification";
        }

        Optional<Product> test = productRepository.findById(newProductBatch.getProductSku());
        if(test.isPresent()) {
            List<Product> temp = productRepository.findBysku(newProductBatch.getProductSku());
            Product l = temp.get(0);
            newProductBatch.setName(l.getName());
            productBatchRepository.save(newProductBatch);
            System.out.print(newProductBatch.toString() + " saved successfully\n");
            System.out.println("Total number of saved products: " + productBatchRepository.count());
        }
        List<ProductBatchEntry> productList = productBatchRepository.findAll();
        model.addAttribute("listOfAllProductBatches", productBatchRepository.findAll());
        model.addAttribute("newProductBatch", new ProductBatchEntry());
        model.addAttribute("deleteProductBatch", new ProductBatchEntry());

        return "redirect:/productBatch";
    }

    @Transactional
    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute(name = "updateLocation") ProductBatchEntry updateLocation,  Model model) {
        String message;
        ProductBatchEntry prodBatch;
        System.out.println(updateLocation.toString());

        Optional<ProductBatchEntry> test = productBatchRepository.findById(updateLocation.batchId);
        if(test.isPresent()) {
            List<ProductBatchEntry> l = productBatchRepository.findBybatchId(updateLocation.batchId);
            prodBatch = l.get(0);
            prodBatch.setLocation(updateLocation.getLocation());
            productBatchRepository.save(prodBatch);
            return "redirect:/productBatch";
        }
        System.out.print(updateLocation.toString() + " saved successfully\n");
        productBatchRepository.save(updateLocation);
        System.out.println("Total number of saved products: " + productBatchRepository.count());

        return "redirect:/productBatch";
    }

    @Transactional
    @RequestMapping(value = "/updateQuantity", method = RequestMethod.POST)
    public String updateQuantity(@ModelAttribute(name = "updateQuantity") ProductBatchEntry updateQuantity,  Model model) {
        String message;
        ProductBatchEntry prodBatch;
        System.out.println(updateQuantity.toString());

        Optional<ProductBatchEntry> test = productBatchRepository.findById(updateQuantity.batchId);
        if(test.isPresent()) {
            List<ProductBatchEntry> l = productBatchRepository.findBybatchId(updateQuantity.batchId);
            prodBatch = l.get(0);
            prodBatch.setQuantity(updateQuantity.getQuantity());
            productBatchRepository.save(prodBatch);
            return "redirect:/productBatch";
        }
        System.out.print(updateQuantity.toString() + " saved successfully\n");
        productBatchRepository.save(updateQuantity);
        System.out.println("Total number of saved products: " + productBatchRepository.count());

        return "redirect:/productBatch";
    }

    @RequestMapping(value = "/deleteProductBatch", method = RequestMethod.POST)
    public String deleteProductBatch(@ModelAttribute(name = "deleteProductBatch") ProductBatchEntry deleteProductBatch, Model model) {

        String message;
        System.out.println("Product Batch ID:" + deleteProductBatch.batchId);
        Optional<ProductBatchEntry> test = productBatchRepository.findById(deleteProductBatch.getBatchId());
        System.out.println(test.toString());
        if(test.isPresent()) {
            System.out.println("Product is present" + test.toString());
            productBatchRepository.deleteById((long) deleteProductBatch.batchId);
            message = "Product Batch of batch ID: " + deleteProductBatch.batchId + " was successfully deleted";
            model.addAttribute("message", message);
        }
        return "redirect:/productBatch";

    }
}