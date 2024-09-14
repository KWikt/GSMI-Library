package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.model.Vendor;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VendorProfileController {

    @Autowired
    public VendorService vendorService;

    @Autowired
    public InvoiceService invoiceService;

    @GetMapping("/vendor/profile/{id}")
    public String start(@PathVariable long id, Model model) {
        Vendor vendor = vendorService.getVendorById(id);
        List<Invoice> invoices = invoiceService.getAllInvoices();
        List<Invoice> vendorInvoices = new ArrayList<>();

        for (Invoice invoice : invoices) {
            if (invoice.getVendorName().equals(vendor.getCompanyName())){
                vendorInvoices.add(invoice);
            }
        }
        model.addAttribute("invoices", vendorInvoices);
        model.addAttribute("vendor", vendor);
        return "vendorProfile";
    }



}
