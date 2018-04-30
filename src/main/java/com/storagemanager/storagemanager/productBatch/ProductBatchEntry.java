package com.storagemanager.storagemanager.productBatch;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by NHima on 4/25/18.
 */
@Entity
@Table(name = "productBatch")
public class ProductBatchEntry {

    @Id @GeneratedValue
    long batchId;
    @Column(name = "PRODUCTSKU")
    int productSku;
    @Column(name = "QUANTITY")
    int quantity;
    @Column(name = "LOCATION")
    String location;
    @Column(name = "DATERECEIVED")
    Date dateReceived;
    @Column(name = "PERISHABLE")
    boolean perishable = true;

    protected ProductBatchEntry() {}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public int getProductSku() {
        return productSku;
    }

    public void setProductSku(int productSku) {
        this.productSku = productSku;
    }

    public long getBatchId() {
        return batchId;
    }

    public void setBatchId(long batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "ProductBatchEntry{" +
                "batchId=" + batchId +
                ", productSku=" + productSku +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", dateReceived=" + dateReceived +
                ", perishable=" + perishable +
                '}';
    }
}
