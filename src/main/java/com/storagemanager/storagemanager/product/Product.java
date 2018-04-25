package com.storagemanager.storagemanager.product;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by NHima on 4/22/18.
 * POJO of the Product Java Object, including attributes.
 * Currently only 3 fields, name | sku | and description, with corresponding getters and setters.
 *
 * NHima 4/24/18
 * Adding salePrice | wholeSaleCost | category, & getters/setters
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "SKU")
    long sku;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "NAME")
    String name;
    @Column(name = "SALEPRICE")
    double salePrice;
    @Column(name = "WHOLESALECOST")
    double wholeSaleCost;
    @Column(name = "CATEGORY")
    String category;

    protected Product() {}

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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getWholeSaleCost() {
        return wholeSaleCost;
    }

    public void setWholeSaleCost(double wholeSaleCost) {
        this.wholeSaleCost = wholeSaleCost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
