package com.softtech.case3.service.entityservice;

import com.softtech.case3.dao.ReviewDao;
import com.softtech.case3.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewEntityService {
    private final ReviewDao reviewDao;

    public Review save(Review review) {
        return reviewDao.save(review);
    }

    public void delete(Review review) {
        reviewDao.delete(review);
    }

    public Optional<Review> findById(Long id) {
        return reviewDao.findById(id);
    }

    /**
     * This method finds review by id with control.
     * If there is no review related to the id, an exception appears.
     */
    public Review findByIdWithControl(Long id) {
        Optional<Review> reviewOptional = findById(id);
        Review review;
        if(reviewOptional.isPresent()) {
            review = reviewOptional.get();
        }
        else {
            throw new RuntimeException("Review not found!");
        }
        return review;
    }

    public List<Review> findAllByUserId(Long userId) {
        return reviewDao.findAllByUserId(userId);
    }

    public List<Review> findAllByProductId(Long productId) {
        return reviewDao.findAllByProductId(productId);
    }
}
