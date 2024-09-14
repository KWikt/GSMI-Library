package com.wiktorkk.gsmi.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private long id;

    private String vendorName;
    private String invoiceNumber;
    private String documentType;
    private String grossAmount;
    private String vatAmount;
    private Date invoiceDate;
    private Date dueDate;
    private Date paymentDate;
    private String paymentStatus;
    private String notes;


    public Invoice() {
    }

    public Invoice(long id, String vendorName, String invoiceNumber, String documentType, String grossAmount, String vatAmount, Date invoiceDate, Date dueDate, Date paymentDate, String paymentStatus, String notes) {
        this.id = id;
        this.vendorName = vendorName;
        this.invoiceNumber = invoiceNumber;
        this.documentType = documentType;
        this.grossAmount = grossAmount;
        this.vatAmount = vatAmount;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.notes = notes;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(String vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
