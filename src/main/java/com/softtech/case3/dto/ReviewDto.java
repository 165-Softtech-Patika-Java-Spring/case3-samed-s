package com.softtech.case3.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long userId;
    private Long productId;
    private String review;
}
