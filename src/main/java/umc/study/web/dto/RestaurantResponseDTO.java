package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class RestaurantResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addToRegionResultDTO{

        Long restaurantId;

        String name;

        String address;

        Long regionId;

        LocalDateTime createdAt;

        LocalDateTime updatedAt;
    }
}
