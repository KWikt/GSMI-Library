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
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/invoice")
    public String start(Model model) {
        Invoice invoice = new Invoice();
        List<String> vendorsName = vendorService.getVendorsName();
        model.addAttribute("invoice", invoice);
        model.addAttribute("vendors", vendorsName);
        return "invoice";
    }

    @PostMapping("/invoice")
    public String save(@ModelAttribute("invoice") Invoice invoice) {
            invoice.setVendorID(vendorService.getVendorIDbyName(invoice.getVendorName()));
            invoiceService.save(invoice);
            return "redirect:index";
    }

    // Pewne zaklamanie, nie moge zrobic DeleteMapping na samym htmlu
    @GetMapping("/invoice/delete/{id}")
    public String deleteInvoice(@PathVariable long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/index";
    }

}