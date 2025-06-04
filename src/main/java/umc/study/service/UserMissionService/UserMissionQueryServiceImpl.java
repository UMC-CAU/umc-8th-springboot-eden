package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements  UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    private final UserRepository userRepository;

    @Override
    public Optional<UserMission> findOngoingById(Long userId, Long missionId) {

        return userMissionRepository.findByUserIdAndMissionId(userId, missionId);
    }

    @Override
    public Page<UserMission> getByUserByStatusByPage(Long userId, MissionStatus missionStatus, int number, int size) {
        User user = userRepository.findById(userId).orElse(null);

        return userMissionRepository.findByUserAndMissionStatus(user, missionStatus, PageRequest.of(number, size));
    }
}
