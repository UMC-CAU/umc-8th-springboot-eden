package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

public class RestaurantConverter {

    // 식당 객체 -> DTO
    public static RestaurantResponseDTO.addToRegionResultDTO toRestaurantDTO(Restaurant restaurant){
        return RestaurantResponseDTO.addToRegionResultDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .regionId(restaurant.getRegion().getId())
                .build();
    }

    // DTO -> 식당 객체
    public static Restaurant toRestaurantEntity(RestaurantRequestDTO.addToRegionDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .category(request.getCategory())
                .address(request.getAddress())
                .build();
    }
}
