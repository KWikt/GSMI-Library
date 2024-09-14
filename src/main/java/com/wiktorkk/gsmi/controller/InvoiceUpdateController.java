package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceUpdateController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/invoice/update/{id}")
    public String edit(@PathVariable long id, Model model) {
        Invoice invoice = invoiceService.getInvoice(id);
        List<String> vendorsName = vendorService.getVendorsName();
        model.addAttribute("invoice", invoice);
        model.addAttribute("vendors", vendorsName);
        return "updateInvoice";
    }

    @PostMapping("/invoice/update/{id}")
    public String update(@PathVariable long id, @ModelAttribute("invoice") Invoice invoice) {
        invoiceService.updateInvoice(id, invoice);
        return "redirect:/index";
    }
}
