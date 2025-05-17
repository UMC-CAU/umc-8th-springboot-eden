package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.Restaurant;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addToRegion(RestaurantRequestDTO.addToRegionDTO request) {

        Restaurant newRestaurant = RestaurantConverter.toRestaurantEntity(request);

        return restaurantRepository.save(newRestaurant);
    }
}
