package com.storagemanager.storagemanager.storageManager;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface StorageManagerRepository extends CrudRepository<StorageManager, Long> {

    List<StorageManager> findAll();

}
