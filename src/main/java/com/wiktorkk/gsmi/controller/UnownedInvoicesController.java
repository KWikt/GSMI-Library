package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.model.User;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UnownedInvoicesController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private UserService userService;

    @GetMapping("/unownedInvoices")
    public String start(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            User user = userService.findByUsername((String) session.getAttribute("username"));
            List<Invoice> invoices = invoiceService.getAllInvoiceByUser(user.getId());
            List<Invoice> unowned = new ArrayList<>();

            for (Invoice invoice : invoices) {
                if (invoice.getVendorName().equals("Blank") || (invoice.getVendorName().isEmpty()))  {
                    unowned.add(invoice);
                }
            }
            model.addAttribute("invoices", unowned);
            return "unownedInvoices";
        }
    }

}
