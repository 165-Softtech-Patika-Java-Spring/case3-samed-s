package com.softtech.case3.service;

import com.softtech.case3.converter.ReviewMapper;
import com.softtech.case3.dto.ProductDto;
import com.softtech.case3.dto.ReviewDto;
import com.softtech.case3.dto.UserDto;
import com.softtech.case3.entity.Review;
import com.softtech.case3.service.entityservice.ReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewEntityService reviewEntityService;
    private final ProductService productService;
    private final UserService userService;

    public ReviewDto save(ReviewDto reviewDto) {
        Review review = ReviewMapper.INSTANCE.convertToReview(reviewDto);
        review = reviewEntityService.save(review);
        ReviewDto resultReviewDto = ReviewMapper.INSTANCE.convertToReviewDto(review);
        return resultReviewDto;
    }

    public void delete(Long id) {
        Review review = reviewEntityService.findByIdWithControl(id);
        reviewEntityService.delete(review);
    }

    /**
     * This method finds all reviews by userId for a user.
     * If the user has not written any reviews, an exception appears with username
     */
    public List<ReviewDto> findAllByUserId(Long userId) {
        List<Review> reviewList = reviewEntityService.findAllByUserId(userId);
        UserDto userDto = userService.findById(userId);
        if(reviewList.isEmpty()) {
            throw new RuntimeException("The user " + userDto.getUsername() + " has not written any reviews yet.");
        }
        List<ReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertToReviewDtoList(reviewList);
        return reviewDtoList;
    }

    /**
     * This method finds all reviews by productId for a product
     * If the product has not got any reviews, an exception appears with product name
     */
    public List<ReviewDto> findAllByProductId(Long productId) {
        List<Review> reviewList = reviewEntityService.findAllByProductId(productId);
        ProductDto productDto = productService.findById(productId);
        if(reviewList.isEmpty()) {
            throw new RuntimeException("There are no reviews for product " + productDto.getName());
        }
        List<ReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertToReviewDtoList(reviewList);
        return reviewDtoList;
    }
}
