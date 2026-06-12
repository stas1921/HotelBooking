package com.hotelbooking.controller;

import com.hotelbooking.entity.Review;
import com.hotelbooking.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepository;
    
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @GetMapping("/hotel/{hotelId}")
    public List<Review> getReviewsByHotel(@PathVariable Long hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }
    
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }
}