package com.storagemanager.storagemanager.storageTransaction;

import com.storagemanager.storagemanager.productBatch.ProductBatchEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by NHima on 4/22/18.
 * Controller for all methods using StorageTransaction Object
 */

@Controller
@RequestMapping(value = "/transaction")
public class StorageTransactionController {

    @Autowired
    StorageTransactionRepository storageTransactionRepository;

    @GetMapping
    public String returnProductBatch(Model model)
    {
        List<StorageTransaction> storageTransactionList = storageTransactionRepository.findAll();
        for (StorageTransaction iteration: storageTransactionList) {
            System.out.println(iteration.toString());

        }
        model.addAttribute("listOfAllTransactions", storageTransactionRepository.findAll());
        model.addAttribute("newTransaction", new StorageTransaction());
        model.addAttribute("deleteTransaction", new StorageTransaction());
        return "transaction";
    }

    @RequestMapping("/products/{sku}/products")
    public Iterable<StorageTransaction> getTransactionsBySKU(@PathVariable long sku) {
        List<Long> skuList = null;
        skuList.add(sku);
        Iterable<StorageTransaction> transactions = null;
        transactions = storageTransactionRepository.findAllById(skuList);
        return transactions;
    }
}


