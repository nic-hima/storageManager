package com.storagemanager.storagemanager.product;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by NHima on 4/22/18.
 * POJO of the Product Java Object, including attributes.
 * Currently only 3 fields, name | sku | and description, with corresponding getters and setters.
 */

@Entity
public class Product {

    @Id
    @Column(name = "SKU")
    long sku;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "NAME")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
