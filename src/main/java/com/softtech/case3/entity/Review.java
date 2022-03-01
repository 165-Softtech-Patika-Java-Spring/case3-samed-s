package com.softtech.case3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
@Getter
@Setter
public class Review {

    @Id
    @SequenceGenerator(name = "Review", sequenceName = "REVIEW_ID_SEQ")
    @GeneratedValue(generator = "Review")
    private Long id;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_PRODUCT")
    private Long productId;

    @Column(name = "REVIEW", length = 500)
    private String review;
}
