package org.example.backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}

