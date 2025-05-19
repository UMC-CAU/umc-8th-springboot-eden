package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

public class RestaurantConverter {

    // 식당 객체 -> DTO
    public static RestaurantResponseDTO.AddToRegionResultDTO toRestaurantDTO(Restaurant restaurant){
        return RestaurantResponseDTO.AddToRegionResultDTO.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .regionId(restaurant.getRegion().getId())
                .createdAt(restaurant.getCreatedAt())
                .updatedAt(restaurant.getUpdatedAt())
                .build();
    }

    // DTO -> 식당 객체
    public static Restaurant toRestaurantEntity(RestaurantRequestDTO.AddToRegionDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .category(request.getCategory())
                .address(request.getAddress())
                .build();
    }
}
