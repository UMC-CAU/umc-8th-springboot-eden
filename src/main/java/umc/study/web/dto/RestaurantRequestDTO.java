package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class AddToRegionDTO {

        @NotBlank(message = "이름을 입력하세요")
        String name;

        @NotBlank(message = "카테고리를 입력하세요")
        String category;

        @NotBlank(message = "주소를 입력하세요")
        String address;
    }
}
