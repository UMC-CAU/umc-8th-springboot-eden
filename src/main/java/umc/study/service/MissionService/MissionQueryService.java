package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findById(Long id);
    Page<Mission> getByRestaurantByPage(Long restaurantId, int number, int size);
}
