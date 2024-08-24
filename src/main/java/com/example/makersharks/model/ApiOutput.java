package com.example.makersharks.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "api output structure")
public class ApiOutput<T> {

    @Schema(description = "page number of the response")
    public int page;

    @Schema(description = "the response from the api")
    public List<T> result;

    @Schema(description = "the total count of results in particular page")
    public int count;

    @Schema(description = "the total count of results found on the database")
    public int totalResults;

    @Schema(description = "message from the server")
    public String message;


    public ApiOutput(int page, int totalResults, List<T> result) {
        this.page = page;
        this.result = result;
        this.totalResults = totalResults;
        this.count = this.result.size();
        this.message = "NA";
    }

    public ApiOutput(int page, int totalResults, List<T> result, String message) {
        this.page = page;
        this.result = result;
        this.totalResults = totalResults;
        this.count = this.result.size();
        this.message = message;
    }
}
