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
public class MainBoardController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getInvoices(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            List<Invoice> invoices = invoiceService.getAllInvoices();
            List<Invoice> userInvoices = new ArrayList<>();
            User user = userService.findByUsername((String)session.getAttribute("username"));
            for (Invoice invoice : invoices) {
                if (invoice.getUser().equals(user)){
                    if(!invoice.getPaymentStatus().equals("Paid")){
                        userInvoices.add(invoice);
                    }
                }
            }
            model.addAttribute("invoices", userInvoices);
            return "index";
        }
    }

    @GetMapping("/")
    public String getToStart() {
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }



}
