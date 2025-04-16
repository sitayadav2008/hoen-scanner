package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.skyscanner.resources.SearchResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.util.ArrayList;
import java.util.List;
import com.skyscanner.model.SearchResult;


public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<SearchResult>> typeRef = new TypeReference<>() {};

        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(mapper.readValue(Resources.getResource("rental_cars.json"), typeRef));
        searchResults.addAll(mapper.readValue(Resources.getResource("hotels.json"), typeRef));

    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {

    }

    @Override
    public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<SearchResult>> typeRef = new TypeReference<>() {};
        List<SearchResult> searchResults = new ArrayList<>();

        searchResults.addAll(mapper.readValue(Resources.getResource("rental_cars.json"), typeRef));
        searchResults.addAll(mapper.readValue(Resources.getResource("hotels.json"), typeRef));

        // Register the resource
        environment.jersey().register(new SearchResource(searchResults));
    }


}
