package com.example.makersharks.dao;

import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierDaoTests {

    private static SupplierDao supplierDao;

    @BeforeAll
    static void setup() {
        supplierDao = new InMemorySupplierDataAccessService();
    }

    @Test
    public void add_supplier_should_success() {
        Supplier supplier = new Supplier("Test", "www.test.com", "test", SCALE.small, SERVICE.casting);

        supplierDao.addSupplier(supplier);

        assertEquals(supplierDao.getSupplier().size(), 1);
    }
}
