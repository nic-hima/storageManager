package com.storagemanager.storagemanager.productBatch;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductBatchRepository extends CrudRepository<ProductBatchEntry, Long> {

    List<ProductBatchEntry> findAll();
    List<ProductBatchEntry> findByproductSku(int productSku);
}