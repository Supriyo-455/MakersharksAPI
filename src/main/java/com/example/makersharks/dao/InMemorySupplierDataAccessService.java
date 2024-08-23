package com.example.makersharks.dao;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.util.SupplierGenerator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InMemory")
public class InMemorySupplierDataAccessService implements SupplierDao {

    private List<Supplier> db = SupplierGenerator.generateRandomSuppliers(100);

    @Override
    public boolean addSupplier(Supplier supplier) {
        db.add(supplier);
        return true;
    }

    @Override
    public List<Supplier> getSupplier() {
        return db;
    }
}
