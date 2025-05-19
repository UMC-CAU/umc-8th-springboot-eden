package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final RestaurantRepository restaurantRepository;

    private final MissionRepository missionRepository;

    @Override
    public Mission create(Long restaurantId, MissionRequestDTO.CreateDTO request) {

        Mission newMission = MissionConverter.toMissionEntity(request);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        // 연관관계 한 번에 처리
        restaurant.addMission(newMission);

        return missionRepository.save(newMission);
    }
}
