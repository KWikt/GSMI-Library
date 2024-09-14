package com.wiktorkk.gsmi.service;

import com.wiktorkk.gsmi.dao.InvoiceDao;
import com.wiktorkk.gsmi.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;


    public void save(Invoice invoice) {
        invoiceDao.save(invoice);
    }

    public Invoice getInvoice(long id) {
        return  invoiceDao.getReferenceById(id);
    }

    public List<Invoice> getAllInvoices() {
        return  invoiceDao.findAll();
    }

    public void deleteInvoice(long id) {
        invoiceDao.deleteById(id);
    }

    public List<Invoice> getAllInvoiceByUser(long userId) {
        List<Invoice> invoices = invoiceDao.findAll();
        List<Invoice> invoicesByVendor = new ArrayList<>();

        for (Invoice invoice : invoices) {
            if(invoice.getUser().getId() == userId) {
                invoicesByVendor.add(invoice);
            }
        }
        return invoicesByVendor;
    }

    public List<Invoice> findAllInvoiceByVendorID(Long id) {
        List<Invoice> invoices = invoiceDao.findAll();
        List<Invoice> invoicesByVendor = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getVendorID() == id) {
                invoicesByVendor.add(invoice);
            }
        }
        return invoicesByVendor;
    }

    public void updateInvoice(Long id, Invoice invoice) {
        Invoice newInvoice = invoiceDao.getReferenceById(id);
        newInvoice.setInvoiceNumber(invoice.getInvoiceNumber());
        newInvoice.setInvoiceDate(invoice.getInvoiceDate());
        newInvoice.setVendorName(invoice.getVendorName());
        newInvoice.setDocumentType(invoice.getDocumentType());
        newInvoice.setDueDate(invoice.getDueDate());
        newInvoice.setGrossAmount(invoice.getGrossAmount());
        newInvoice.setNotes(invoice.getNotes());
        newInvoice.setVatAmount(invoice.getVatAmount());
        newInvoice.setPaymentStatus(invoice.getPaymentStatus());
        newInvoice.setId(id);
        invoiceDao.save(newInvoice);
    }
}
