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
    Long batchId;
    @Column(name = "PRODUCTSKU")
    Long productSku;
    @Column(name = "QUANTITY")
    int quantity;
    @Column(name = "LOCATION")
    String location;
    @Column(name = "DATERECEIVED")
    Date dateReceived;
    @Column(name = "NAME")
    String name;

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

    public Long getProductSku() {
        return productSku;
    }

    public void setProductSku(Long productSku) {
        this.productSku = productSku;
    }


    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {

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
                ", Name=" + name +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
