package com.storagemanager.storagemanager.storageTransaction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by NHima on 4/22/18.
 * POJO of the StorageTransaction Java Object
 * Currently only 4 fields, type | sku | quantity | transactionDate, with corresponding getters and setters
 *
 *
 */
@Entity
@Table(name = "transaction")
public class StorageTransaction {
    @Id @GeneratedValue
    Long transactionID;
    @Column(name = "TYPE")
    boolean type;
    @Column(name = "SKU")
    Long sku;
    @Column(name = "QUANTITY")
    int quantity;
    @Column(name = "TRANS_DATE")
    Date transactionDate;

    protected StorageTransaction() {}

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
