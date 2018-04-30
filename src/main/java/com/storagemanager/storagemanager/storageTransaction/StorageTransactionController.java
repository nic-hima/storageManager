package com.storagemanager.storagemanager.storageTransaction;

import com.storagemanager.storagemanager.productBatch.ProductBatchEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Transactional
    public String createTransaction(@ModelAttribute(name = "newTransaction") StorageTransaction newTransaction, Model model) {
        String message;
        System.out.println(newTransaction.toString());
        if (1==0)
        {
            String output = "Invalid Form";
            System.out.print("Validation errors while submitting form");
            model.addAttribute("message", output);
            return "notification";
        }
        System.out.print(newTransaction.toString() + " saved successfully\n");
        storageTransactionRepository.save(newTransaction);
        System.out.println("Total number of Transactions: " + storageTransactionRepository.count());
        List<StorageTransaction> productList = storageTransactionRepository.findAll();

        return "redirect:/transaction";
    }
}


