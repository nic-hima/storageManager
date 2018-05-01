package com.storagemanager.storagemanager.storageManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by NHima on 4/24/18.
 * POJO of the StorageManager Java Object, including attributes.
 * Currently only 2 fields, username | password, & getters/setters
 */

@Entity
@Table(name = "storageManager")
public class StorageManager {

    @Id
    @Column(name = "USERNAME")
    String username;
    @Column(name = "PASSWORD")
    String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StorageManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
