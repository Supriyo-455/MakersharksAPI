package com.example.makersharks.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Supplier {
    private final UUID supplier_id;
    private final String company_name;
    private final String website;
    private final String location; // NOTE: city, assuming one supplier_id maps to just one location
    private final SCALE business_nature;
    private final SERVICE manufacturing_processes;

    public Supplier(@JsonProperty("company_name") String company_name,
                    @JsonProperty("website") String website,
                    @JsonProperty("location") String location,
                    @JsonProperty("business_nature") SCALE business_nature,
                    @JsonProperty("manufacturing_processes") SERVICE manufacturing_processes
    ) {
        this.supplier_id = UUID.randomUUID();
        this.company_name = company_name;
        this.website = website;
        this.location = location;
        this.business_nature = business_nature;
        this.manufacturing_processes = manufacturing_processes;
    }

    public UUID getSupplier_id() {
        return supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getWebsite() {
        return website;
    }

    public String getLocation() {
        return location;
    }

    public SCALE getBusiness_nature() {
        return business_nature;
    }

    public SERVICE getManufacturing_processes() {
        return manufacturing_processes;
    }
}
