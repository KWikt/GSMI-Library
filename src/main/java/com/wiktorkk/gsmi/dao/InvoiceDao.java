package com.wiktorkk.gsmi.dao;

import com.wiktorkk.gsmi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Long> {
}
