package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainBoardController {

    @Autowired
    private InvoiceService invoiceService;



    @GetMapping("/index")
    public String getInvoices(Model model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        // Dorobic zeby lista byla przede wszysktim zaczynajaca sie od faktury najblizej koncowi
        // I byly tylko otwarte
        model.addAttribute("invoices", invoices);
        return "index";
    }


}
