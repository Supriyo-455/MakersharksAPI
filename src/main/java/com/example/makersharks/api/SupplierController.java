package com.example.makersharks.api;


import com.example.makersharks.model.ApiResponse;
import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import com.example.makersharks.service.SupplierService;
import com.example.makersharks.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("api/supplier")
@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @GetMapping
    public ApiResponse<Supplier> getSuppliers(@RequestParam(required = true, defaultValue = "1") int page) {
        List<List<Supplier>> pages = PaginationUtil.getPages(supplierService.getSuppliers(), 10);
        return new ApiResponse<>(page, pages.get(page));
    }

    @RequestMapping("query")
    @GetMapping
    public ApiResponse<Supplier> filterSupplier(@RequestParam(required = true, defaultValue = "1") int page, @RequestParam(required = false) SCALE businessNature, @RequestParam(required = false) SERVICE manufacturingProcess, @RequestParam(required = false) String location) {
        List<List<Supplier>> pages = PaginationUtil.getPages(supplierService.getSuppliers(), 10);

        Stream<Supplier> supplierStream = supplierService.getSuppliers().stream();
        if(businessNature != null) {
            supplierStream = supplierStream.filter(supplier -> supplier.getBusiness_nature() == businessNature);
        }
        if(manufacturingProcess != null) {
            supplierStream = supplierStream.filter(supplier -> supplier.getManufacturing_processes() == manufacturingProcess);
        }
        if(location != null) {
            supplierStream = supplierStream.filter(supplier -> Objects.equals(supplier.getLocation(), location));
        }
        return new ApiResponse<>(page, pages.get(page));
    }
}
