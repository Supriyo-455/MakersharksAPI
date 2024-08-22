package com.example.makersharks.service;


import com.example.makersharks.dao.SupplierDao;
import com.example.makersharks.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    @Qualifier("InMemory")
    private SupplierDao supplierDao;

    public boolean addSupplier(Supplier supplier) {
        return supplierDao.addSupplier(supplier);
    }

    public List<Supplier> getSuppliers() {
        return supplierDao.getSupplier();
    }
}
