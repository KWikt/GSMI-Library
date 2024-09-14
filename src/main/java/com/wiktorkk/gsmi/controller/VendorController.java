package com.wiktorkk.gsmi.controller;

import com.wiktorkk.gsmi.model.Invoice;
import com.wiktorkk.gsmi.model.User;
import com.wiktorkk.gsmi.model.Vendor;
import com.wiktorkk.gsmi.service.InvoiceService;
import com.wiktorkk.gsmi.service.UserService;
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
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private UserService userService;

    @GetMapping("/vendor")
    public String start(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            Vendor vendor = new Vendor();
            model.addAttribute("vendor", vendor);
            return "vendor";
        }
    }

    @GetMapping("/vendorList")
    public String vendorList(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            User user = userService.findByUsername((String) session.getAttribute("username"));
            model.addAttribute("vendors", vendorService.getAllVendorsByUserId(user.getId()));
            return "vendorList";
        }
    }


    @PostMapping("/vendor")
    public String save(@ModelAttribute("vendor") Vendor vendor, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            User user = userService.findByUsername((String)session.getAttribute("username"));
            vendor.setUser(user);
            vendorService.saveVendor(vendor);
            return "redirect:/index";
        }
    }

    // Pewne zaklamanie, nie moge zrobic DeleteMapping na samym htmlu
    @GetMapping("/vendor/delete/{id}")
    public String deleteVendor(@PathVariable long id, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        } else {
            User user = userService.findByUsername((String)session.getAttribute("username"));

            // Teoretycznie zapobiega przed usunieciem nie swojego vendora
            if(vendorService.getVendorById(id).getUser().getId() != user.getId()) {
                return "redirect:/index";
            } else {
                List<Invoice> invoices = invoiceService.findAllInvoiceByVendorID(id);
                if (!invoices.isEmpty()) {
                    for (Invoice invoice : invoices) {
                        invoice.setVendorName("Blank");
                    }
                }
                vendorService.deleteVendor(id);
                return "redirect:/index";
            }
        }
    }

}
