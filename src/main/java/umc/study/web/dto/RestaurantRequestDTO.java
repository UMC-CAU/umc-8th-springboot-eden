package umc.study.web.dto;

import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class addToRegionDTO {

        String name;

        String category;

        String address;
    }
}
