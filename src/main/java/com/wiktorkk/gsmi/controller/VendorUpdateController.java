package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.model.Vendor;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.VendorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VendorUpdateController {

    @Autowired
    VendorService vendorService;

    @Autowired
    InvoiceService invoiceService;


    @GetMapping("/vendor/updateVendor/{id}")
    public String start(@PathVariable long id, Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            Vendor vendor = vendorService.getVendorById(id);
            model.addAttribute("vendor", vendor);
            return "updateVendor";
        }
    }

    @PostMapping("/vendor/updateVendor/{id}")
    public String update(@PathVariable long id, @ModelAttribute("vendor") Vendor vendor, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            List<Invoice> invoices = invoiceService.findAllInvoiceByVendorID(id);
            if (!invoices.isEmpty()) {
                for (Invoice invoice : invoices) {
                    invoice.setVendorName(vendor.getCompanyName());
                }
            }
            vendorService.updateVendor(id, vendor);
            return "redirect:/vendor/profile/" + vendor.getId().toString();
        }
    }
}
