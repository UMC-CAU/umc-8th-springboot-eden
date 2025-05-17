package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RegionResponseDTO;

public class RegionConverter {

    public static RegionResponseDTO.addRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant){
        return RegionResponseDTO.addRestaurantResultDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .regionId(restaurant.getRegion().getId())
                .build();
    }
}
