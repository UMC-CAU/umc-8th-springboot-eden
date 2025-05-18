package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewRestaurantResultDTO {

        Long reviewId;

        Integer rating;

        String content;

        LocalDateTime createdAt;

        LocalDateTime updatedAt;
    }
}
