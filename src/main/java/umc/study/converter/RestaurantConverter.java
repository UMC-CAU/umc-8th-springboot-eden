package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RestaurantResponseDTO;

public class RestaurantConverter {

    public static RestaurantResponseDTO.addToRegionResultDTO toRestaurant(Restaurant restaurant){
        return RestaurantResponseDTO.addToRegionResultDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .regionId(restaurant.getRegion().getId())
                .build();
    }
}
