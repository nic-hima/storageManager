package com.storagemanager.storagemanager.transaction;

import com.storagemanager.storagemanager.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by NHima on 4/22/18.
 * Controller for all methods using Transaction Object
 */

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping("/products/{sku}/products")
    public Iterable<Transaction> getTransactionsBySKU(@PathVariable long sku) {
        List<Long> skuList = null;
        skuList.add(sku);
        Iterable<Transaction> transactions = null;
        transactions = transactionRepository.findAllById(skuList);
        return transactions;
    }
}


