package com.example.makersharks.dao;

import com.example.makersharks.model.Supplier;

import java.util.List;

public interface SupplierDao {
    boolean addSupplier(Supplier supplier);
    List<Supplier> getSupplier();
}
