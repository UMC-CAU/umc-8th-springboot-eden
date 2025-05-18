package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RegionResponseDTO;

public class RegionConverter {

    public static RegionResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant){
        return RegionResponseDTO.AddRestaurantResultDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .regionId(restaurant.getRegion().getId())
                .build();
    }
}
