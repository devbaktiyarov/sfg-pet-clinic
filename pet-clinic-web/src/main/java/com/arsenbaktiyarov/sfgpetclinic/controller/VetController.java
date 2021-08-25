package com.arsenbaktiyarov.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
    @GetMapping({"","/", "/list",
            "/vets-list", "/vets-list.html"})
    public String listVets() {
        return "vets/vets-list";
    }
}
