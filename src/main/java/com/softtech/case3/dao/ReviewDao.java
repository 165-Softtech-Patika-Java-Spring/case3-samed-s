package com.softtech.case3.dao;

import com.softtech.case3.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

    List<Review> findAllByUserId(Long userId);

    List<Review> findAllByProductId(Long productId);
}
