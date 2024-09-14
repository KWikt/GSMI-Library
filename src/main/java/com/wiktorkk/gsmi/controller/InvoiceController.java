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
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private UserService userService;

    @GetMapping("/invoice")
    public String start(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            Invoice invoice = new Invoice();
            User user =  userService.findByUsername((String)session.getAttribute("username"));
            List<String> vendorsName = vendorService.getVendorsName(user);
            model.addAttribute("invoice", invoice);
            model.addAttribute("vendors", vendorsName);
            return "invoice";
        }
    }

    @PostMapping("/invoice")
    public String save(@ModelAttribute("invoice") Invoice invoice, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            invoice.setVendorID(vendorService.getVendorIDbyName(invoice.getVendorName()));
            invoice.setUser(userService.findByUsername((String)session.getAttribute("username")));
            invoiceService.save(invoice);
            return "redirect:index";
        }
    }

    // Pewne zaklamanie, nie moge zrobic DeleteMapping na samym htmlu
    @GetMapping("/invoice/delete/{id}")
    public String deleteInvoice(@PathVariable long id, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {

            User user = userService.findByUsername((String) session.getAttribute("username"));
            // Teoretycznie zapobiega przed usunieciem nie swojej faktury
            if (invoiceService.getInvoice(id).getUser().getId() != user.getId()) {
                return "redirect:/index";
            } else {
                invoiceService.deleteInvoice(id);
                return "redirect:/index";
            }
        }
    }

}