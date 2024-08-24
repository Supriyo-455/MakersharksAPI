package com.example.makersharks.util;

import com.example.makersharks.model.ApiOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PaginationUtil {
    public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
        if (c == null)
            return Collections.emptyList();
        List<T> list = new ArrayList<T>(c);
        if (pageSize == null || pageSize <= 0 || pageSize > list.size())
            pageSize = list.size();
        int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
        List<List<T>> pages = new ArrayList<List<T>>(numPages);
        for (int pageNum = 0; pageNum < numPages;)
            pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
        return pages;
    }

    public static <T> ApiOutput<T> getPage(int page, int totalResults, List<List<T>> pages) {
        if(page-1 <= pages.size() && page >= 1) {
            return new ApiOutput<T>(page, totalResults, pages.get(page-1));
        }

        return new ApiOutput<T>(page, totalResults, Collections.emptyList(), "page index is out of range!");
    }
}
