package umc.study.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewRestaurantDTO {

        Integer rating;

        String content;

    }
}
