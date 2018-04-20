package com.storagemanager.storagemanager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jxf669 on 4/20/18.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
       return "hello Nic how are you?";
   }
}
