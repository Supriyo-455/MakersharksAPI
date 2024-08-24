package com.example.makersharks.dao;

import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SupplierDaoTests {

    private SupplierDao supplierDao;

    @BeforeEach
    void setup() {
        supplierDao = new InMemorySupplierDataAccessService();
    }

    @AfterEach
    void tearDown() {
        supplierDao = new InMemorySupplierDataAccessService();
    }

    @Test
    public void get_suppliers_should_success() {
        assertFalse(supplierDao.getSupplier().isEmpty());
    }
}
