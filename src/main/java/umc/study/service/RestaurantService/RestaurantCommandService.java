package umc.study.service.RestaurantService;

import umc.study.domain.Restaurant;
import umc.study.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {

    Restaurant addToRegion(RestaurantRequestDTO.addToRegionDTO request);
}
