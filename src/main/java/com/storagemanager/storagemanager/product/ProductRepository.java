package com.storagemanager.storagemanager.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by NHima on 4/22/18.
 */
public interface ProductRepository extends CrudRepository <Product, Long> {

    List<Product> findBysku(long sku);

}
