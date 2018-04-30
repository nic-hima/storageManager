package com.storagemanager.storagemanager.productBatch;
import com.storagemanager.storagemanager.product.Product;
import com.storagemanager.storagemanager.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("deleteProduct", new ProductBatchEntry());
        return "productBatch";
    }

    @PostMapping
    @Transactional
    public String createProductBatch(@ModelAttribute(name = "newProductBatch") ProductBatchEntry newProductBatch, @ModelAttribute(name = "deleteProduct") Product deleteProduct, Model model) {
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
        /*Optional<Product> test = productRepository.findById((Long)newProduct.getSku());
        if(test.isPresent() ) {
            System.out.println("Product is present" + test.toString());
        }*/
        return "productBatch";

    }

}
