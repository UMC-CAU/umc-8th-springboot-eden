package umc.study.web.dto;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    public static class reviewRestaurantResultDTO {

        Long reviewId;

        Integer rating;

        String content;

        LocalDateTime createdAt;

        LocalDateTime updatedAt;
    }
}
