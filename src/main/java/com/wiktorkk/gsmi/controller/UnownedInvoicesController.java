package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.service.InvoiceService;
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

    @GetMapping("/unownedInvoices")
    public String start(Model model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        List<Invoice> unowned = new ArrayList<>();

        for (Invoice invoice : invoices) {
            if (invoice.getVendorName().equals("Blank")){
                unowned.add(invoice);
            }
        }
        model.addAttribute("invoices", unowned);
        return "unownedInvoices";
    }

}
