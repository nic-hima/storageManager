package com.storagemanager.storagemanager.storageManager;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface StorageManagerRepository extends CrudRepository<StorageManager, Long> {

    List<StorageManager> findAll();
    List<StorageManager> findByusername(String username);


    Optional<StorageManager> findTestByusername(String username);
}
