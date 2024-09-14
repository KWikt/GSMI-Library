package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.model.User;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.UserService;
import com.wiktorkk.gsmi.service.VendorService;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    private UserService userService;

    @GetMapping("/invoice/updateInvoice/{id}")
    public String edit(@PathVariable long id, Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            Invoice invoice = invoiceService.getInvoice(id);
            User user = userService.findByUsername((String) session.getAttribute("username"));
            List<String> vendorsName = vendorService.getVendorsName(user);
            model.addAttribute("invoice", invoice);
            model.addAttribute("vendors", vendorsName);
            return "updateInvoice";
        }
    }

    @PostMapping("/invoice/updateInvoice/{id}")
    public String update(@PathVariable long id, @ModelAttribute("invoice") Invoice invoice, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            invoice.setVendorID(vendorService.getVendorIDbyName(invoice.getVendorName()));
            invoiceService.updateInvoice(id, invoice);
            return "redirect:/index";
        }
    }
}
