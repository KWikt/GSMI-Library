package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Vendor;
import com.wiktorkk.gsmi.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/vendor")
    public String start(Model model) {
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        return "vendor";
    }


    @PostMapping("/vendor")
    public String save(@ModelAttribute("vendor") Vendor vendor) {
        vendorService.saveVendor(vendor);
        return "redirect:/index";
    }


}
