package com.wiktorkk.gsmi.service;

import com.wiktorkk.gsmi.dao.VendorDao;
import com.wiktorkk.gsmi.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorDao vendorDao;

    public List<Vendor> getAllVendors() {
        return vendorDao.findAll();
    }

    public Vendor getVendorById(long id) {
        return vendorDao.getReferenceById(id);
    }

    public List<String> getVendorsName(){
        List<String> vendors = new ArrayList<>();
        for (Vendor vendor : vendorDao.findAll()) {
            vendors.add(vendor.getCompanyName());
        }
        return vendors;
    }


    public void saveVendor(Vendor vendor) {
        vendorDao.save(vendor);
    }

    public void updateVendor(Long id, Vendor vendor) {
        Vendor newVendor = vendorDao.getReferenceById(id);
        newVendor.setCompanyName(vendor.getCompanyName());
        newVendor.setVatNumber(vendor.getVatNumber());
        newVendor.setAddress(vendor.getAddress());
        newVendor.setCity(vendor.getCity());
        newVendor.setEmail(vendor.getEmail());
        newVendor.setPhone(vendor.getPhone());
        newVendor.setBankAccount1(vendor.getBankAccount1());
        newVendor.setBankAccount2(vendor.getBankAccount2());
        newVendor.setBankAccount3(vendor.getBankAccount3());
        newVendor.setAdditionalInformation(vendor.getAdditionalInformation());
        vendorDao.save(newVendor);
    }

    public void deleteVendor(long id) {
        vendorDao.deleteById(id);
    }

}
