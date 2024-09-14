package com.wiktorkk.gsmi.dao;

import com.wiktorkk.gsmi.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Long> {

}
