package com.example.makersharks.api;


import com.example.makersharks.model.ApiOutput;
import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import com.example.makersharks.service.SupplierService;
import com.example.makersharks.util.PaginationUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Supplier", description = "Supplier APIs")
@RequestMapping("api/supplier")
@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Operation(
            summary = "Add a supplier to the database",
            description = "This will add a supplier in the database. Send the supplier details in the request body.",
            tags = { "supplier", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @GetMapping
    @Operation(
            summary = "Get list of suppliers",
            description = "This will give paginated list of all suppliers.",
            tags = { "supplier", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ApiOutput.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ApiOutput<Supplier> getSuppliers(@RequestParam(required = true, defaultValue = "1") int page) {
        List<List<Supplier>> pages = PaginationUtil.getPages(supplierService.getSuppliers(), 10);
        return new ApiOutput<>(page, pages.get(page));
    }

    @RequestMapping("query")
    @GetMapping
    @Operation(
            summary = "Query the suppliers",
            description = "This will give paginated list of all suppliers queried by location, business process and manufacturing process.",
            tags = { "supplier", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ApiOutput.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ApiOutput<Supplier> filterSupplier(@RequestParam(required = true, defaultValue = "1") int page, @RequestParam(required = false) SCALE businessNature, @RequestParam(required = false) SERVICE manufacturingProcess, @RequestParam(required = false) String location) {
        List<List<Supplier>> pages;

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

        pages  = PaginationUtil.getPages(supplierStream.toList(), 10);
        return new ApiOutput<>(page, pages.get(page));
    }
}