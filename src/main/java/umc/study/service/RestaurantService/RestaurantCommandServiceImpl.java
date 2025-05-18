package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.Region;
import umc.study.domain.Restaurant;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    private final RegionRepository regionRepository;

    @Override
    public Restaurant addToRegion(Long regionId, RestaurantRequestDTO.AddToRegionDTO request) {

        // request 사용해서 새로운 restaurant 객체 생성
        Restaurant newRestaurant = RestaurantConverter.toRestaurantEntity(request);

        // path variable로 전달받은 region id로 region 객체 탐색
        Region region = regionRepository.findById(regionId).orElse(null);   // Todo: 예외 처리 필요

        newRestaurant.setRegion(region);

        return restaurantRepository.save(newRestaurant);
    }
}
