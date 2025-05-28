package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    public Optional<Mission> findById(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Page<Mission> getByRestaurantByPage(Long restaurantId, int number, int size) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(number, size));
    }

}
