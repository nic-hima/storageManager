package com.storagemanager.storagemanager.storageTransaction;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by NHima on 4/22/18.
 */
public interface StorageTransactionRepository extends CrudRepository<StorageTransaction, Long> {

    List<StorageTransaction> findAll();
    List<StorageTransaction> findBySku(Long sku);
}
