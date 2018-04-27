package com.storagemanager.storagemanager.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by NHima on 4/22/18.
 */
public interface ProductRepository extends CrudRepository <Product, Long> {

     List<Product>   findAll();
     List<Product> findBysku(long sku);

    /*@Override
    default List<Product> findAll() {
        return null;
    }
*/
    @Override
    default List<Product> findAllById(Iterable<Long> longs) {
        return null;
    }
}
