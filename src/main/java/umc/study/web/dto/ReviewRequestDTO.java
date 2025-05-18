package umc.study.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class reviewRestaurantDTO {

        Integer rating;

        String content;

    }
}
