package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.repository.MissionRepository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findById(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Page<Mission> getByRestaurantByPage(Restaurant restaurant, int number, int size) {

        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(number, size));
    }

}
