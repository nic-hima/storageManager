package com.storagemanager.storagemanager.storageTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by NHima on 4/22/18.
 * Controller for all methods using StorageTransaction Object
 */

@RestController
public class StorageTransactionController {

    @Autowired
    StorageTransactionRepository storageTransactionRepository;

    @RequestMapping("/products/{sku}/products")
    public Iterable<StorageTransaction> getTransactionsBySKU(@PathVariable long sku) {
        List<Long> skuList = null;
        skuList.add(sku);
        Iterable<StorageTransaction> transactions = null;
        transactions = storageTransactionRepository.findAllById(skuList);
        return transactions;
    }
}


