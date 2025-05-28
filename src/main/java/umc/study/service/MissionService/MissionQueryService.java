package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findById(Long id);
    Page<Mission> getByRestaurantByPage(Long restaurantId, int number, int size);
    Page<Mission> getByUserByPage(Long userId, int number, int size);
}
