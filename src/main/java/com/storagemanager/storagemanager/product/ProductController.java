package com.storagemanager.storagemanager.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by NHima on 4/20/18.
 * Controller for all methods using product Object
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> getProducts() {
    return productRepository.findAll();
        /*List<Product> products = new ArrayList<>();
        Product lettuce = new Product();
        Product tomato = new Product();
        Product cucumber = new Product();

        lettuce.setName("lettuce");
        lettuce.setDescription("Delicious lettuce from lettuce land");
        lettuce.setSku(012345);
        products.add(lettuce);

        tomato.setName("tomato");
        tomato.setDescription("Delicious tomatoes from tomato farms");
        tomato.setSku(011111);
        products.add(tomato);

        cucumber.setName("cucumber");
        cucumber.setDescription("Delicious cucumbers from antarctica");
        cucumber.setSku(101010);
        products.add(cucumber);

        return products;*/

   }

   @RequestMapping(method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.OK)
   @Transactional
    public void postProduct(@RequestBody Product newProduct) {

        System.out.print(newProduct.getName()+ " " + newProduct.getDescription() + " " + newProduct.getSku() + "\n");
        productRepository.save(newProduct);

   }


}
