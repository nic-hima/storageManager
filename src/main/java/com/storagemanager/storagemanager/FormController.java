package com.storagemanager.storagemanager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by macusr on 4/20/18.
 */
@Controller
public class FormController {

        @GetMapping("/Form")
        public String formSubmission(Model model) {
            model.addAttribute("Form", new Form());
            return "form";
        }

        @PostMapping("/Form")
        public String formSubmit(@ModelAttribute Form form) {
            return "result";
        }

}
