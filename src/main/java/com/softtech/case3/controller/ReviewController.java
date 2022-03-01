package com.softtech.case3.controller;

import com.softtech.case3.dto.ReviewDto;
import com.softtech.case3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/user-reviews/{userId}")
    public ResponseEntity findAllByUserId(@PathVariable Long userId) {
        List<ReviewDto> reviewDtoList = reviewService.findAllByUserId(userId);
        return ResponseEntity.ok(reviewDtoList);
    }

    @GetMapping("/{productId}")
    public ResponseEntity findAllByProductId(@PathVariable Long productId) {
        List<ReviewDto> reviewDtoList = reviewService.findAllByProductId(productId);
        return ResponseEntity.ok(reviewDtoList);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ReviewDto reviewDto) {
        ReviewDto resultReviewDto = reviewService.save(reviewDto);
        return ResponseEntity.ok(resultReviewDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }
}
