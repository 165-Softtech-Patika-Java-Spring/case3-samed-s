package com.softtech.case3.converter;

import com.softtech.case3.dto.ReviewDto;
import com.softtech.case3.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review convertToReview(ReviewDto reviewDto);

    ReviewDto convertToReviewDto(Review review);

    List<ReviewDto> convertToReviewDtoList(List<Review> reviewList);
}
