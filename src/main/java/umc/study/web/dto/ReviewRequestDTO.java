package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewRestaurantDTO {

        @NotNull(message = "별점을 입력하세요")
        Integer rating;

        @NotBlank(message = "내용을 입력하세요")
        String content;

    }
}
