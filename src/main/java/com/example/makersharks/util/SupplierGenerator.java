package com.example.makersharks.util;

import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SupplierGenerator {

    private static final Random RANDOM = new Random();

    public static List<Supplier> generateRandomSuppliers(int count) {
        List<Supplier> suppliers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String companyName = "Company" + UUID.randomUUID().toString().substring(0, 8);
            String website = "https://www." + companyName.toLowerCase() + ".com";
            String location = getRandomLocation();
            SCALE businessNature = getRandomScale();
            SERVICE manufacturingProcess = getRandomService();

            Supplier supplier = new Supplier(companyName, website, location, businessNature, manufacturingProcess);
            suppliers.add(supplier);
        }

        return suppliers;
    }

    private static String getRandomLocation() {
        String[] locations = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
        return locations[RANDOM.nextInt(locations.length)];
    }

    private static SCALE getRandomScale() {
        SCALE[] scales = SCALE.values();
        return scales[RANDOM.nextInt(scales.length)];
    }

    private static SERVICE getRandomService() {
        SERVICE[] services = SERVICE.values();
        return services[RANDOM.nextInt(services.length)];
    }
}
