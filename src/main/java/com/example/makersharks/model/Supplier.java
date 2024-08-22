package com.example.makersharks.model;

import java.util.UUID;

enum SCALE {
    SMALL,
    MEDIUM,
    LARGE
}

enum SERVICE {
    MOULDING,
    PRINTING_3D,
    CASTING,
    COATING
}

public class Supplier {
    private final UUID supplier_id;
    private final String company_name;
    private final String website;
    private final String location; // NOTE: city, assuming one supplier_id maps to just one location
    private final SCALE business_nature;
    private final SERVICE manufacturing_processes;

    public Supplier(String company_name, String website, String location, SCALE business_nature, SERVICE manufacturing_processes) {
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
