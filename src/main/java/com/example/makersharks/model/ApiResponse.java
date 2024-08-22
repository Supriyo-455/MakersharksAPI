package com.example.makersharks.model;

import java.util.List;

public class ApiResponse<T> {
    private int page;
    private List<T> result;

    public ApiResponse(int page, List<T> result) {
        this.page = page;
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public List<T> getResult() {
        return result;
    }
}
