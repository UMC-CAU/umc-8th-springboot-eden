package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RegionRequestDTO;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RegionRequestDTO.addRestaurantDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .category(request.getCategory())
                .address(request.getAddress())
                .build();
    }
}
