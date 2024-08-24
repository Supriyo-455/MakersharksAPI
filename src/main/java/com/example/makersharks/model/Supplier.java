package com.example.makersharks.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Supplier model information")
public class Supplier {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "supplier id", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private final UUID supplier_id;

    @Schema(description = "company name, datatype String")
    private final String company_name;

    @Schema(description = "company website, datatype String")
    private final String website;

    @Schema(description = "company location, datatype String")
    private final String location; // NOTE: city, assuming one supplier_id maps to just one location

    @Schema(description = "company business nature, datatype enum")
    private final SCALE business_nature;

    @Schema(description = "company manufacturing process, datatype enum")
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
