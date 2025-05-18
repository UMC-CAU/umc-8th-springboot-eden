package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReviewEntity(ReviewRequestDTO.reviewRestaurantDTO request){
        return Review.builder()
                .rating(request.getRating())
                .content(request.getContent())
                .build();
    }
}
