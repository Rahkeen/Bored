package com.rikin.bored.com.rikin.bored.model.repository;

import java.util.List;

public class StreamsResponse {

    List<StreamData> data;
    PaginationHolder pagination;

    public List<StreamData> getData() {
        return data;
    }

    public PaginationHolder getPagination() {
        return pagination;
    }
}
