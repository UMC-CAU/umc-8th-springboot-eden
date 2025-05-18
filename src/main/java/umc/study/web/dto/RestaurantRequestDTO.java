package umc.study.web.dto;

import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class AddToRegionDTO {

        String name;

        String category;

        String address;
    }
}
