package com.storagemanager.storagemanager.productBatch;
import com.storagemanager.storagemanager.product.Product;
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

    @GetMapping
    public String returnProductBatch(Model model)
    {
        List<ProductBatchEntry> productBatchList = productBatchRepository.findAll();
        for (ProductBatchEntry iteration: productBatchList) {
            System.out.println(iteration.toString());

        }
        model.addAttribute("listOfAllProduct", productBatchRepository.findAll());
        model.addAttribute("newProductBatch", new ProductBatchEntry());
        model.addAttribute("deleteProductBatch", new ProductBatchEntry());
        return "productBatch";
    }

    @PostMapping
    @Transactional
    public String createProductBatch(@ModelAttribute(name = "newProductBatch") ProductBatchEntry newProductBatch, @ModelAttribute(name = "deleteProductBatch") ProductBatchEntry deleteProductBatch, Model model) {
        String message;
        System.out.println(newProductBatch.toString());
        if (1==0)
        {
            String output = "Invalid Form";
            System.out.print("Validation errors while submitting form");
            model.addAttribute("message", output);
            return "notification";
        }
        System.out.print(newProductBatch.toString() + " saved successfully\n");
        productBatchRepository.save(newProductBatch);
        System.out.println("Total number of saved products: " + productBatchRepository.count());
        List<ProductBatchEntry> productList = productBatchRepository.findAll();
        model.addAttribute("listOfAllProductBatches", productBatchRepository.findAll());
        model.addAttribute("newProductBatch", new ProductBatchEntry());
        model.addAttribute("deleteProductBatch", new ProductBatchEntry());

        return "productBatch";
    }

    @RequestMapping(value = "/deleteProductBatch", method = RequestMethod.POST)
    public String deleteProductBatch(@ModelAttribute(name = "deleteProductBatch") ProductBatchEntry deleteProductBatch, @ModelAttribute(name = "productBatchEntry") ProductBatchEntry newProductBatch, Model model) {
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
        else{
            message = "Product of SKU: " + deleteProductBatch.productSku + " was not found";
            model.addAttribute("message", message);
        }
        //return "productBatch";
        return "redirect:/productBatch";

    }
}