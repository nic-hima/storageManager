package com.storagemanager.storagemanager.productBatch;

import com.storagemanager.storagemanager.product.Product;

import java.util.Date;

public class CompleteProductBatchEntry {
    Long sku;
    int quantity;
    String location;
    Date dateReceived;
    boolean perishable;
    String name;
    long id;

    public CompleteProductBatchEntry(ProductBatchEntry productBatchEntry, Product product) {
        this.sku = Long.valueOf(productBatchEntry.getProductSku());
        this.quantity = productBatchEntry.getQuantity();
        this.location = productBatchEntry.getLocation();
        this.dateReceived = productBatchEntry.getDateReceived();
        this.perishable = productBatchEntry.isPerishable();
        this.name = product.getName();
        this.id = productBatchEntry.getBatchId();
    }
}
