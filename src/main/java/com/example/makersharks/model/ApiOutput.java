package com.example.makersharks.model;

import java.util.List;

public class ApiOutput<T> {
    private int page;
    private List<T> result;

    public ApiOutput(int page, List<T> result) {
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
