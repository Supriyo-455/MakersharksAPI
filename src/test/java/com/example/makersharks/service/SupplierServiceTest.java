package com.example.makersharks.service;

import com.example.makersharks.dao.SupplierDao;
import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupplierServiceTest {

    @Mock
    private SupplierDao supplierDao;

    @InjectMocks
    private SupplierService supplierService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void test1_add_supplier_should_pass() {
        Supplier supplier = new Supplier("Test", "www.test.com", "test", SCALE.small, SERVICE.casting);

        Mockito.when(supplierDao.addSupplier(supplier)).thenReturn(true);

        assertTrue(supplierService.addSupplier(supplier));
    }
}
