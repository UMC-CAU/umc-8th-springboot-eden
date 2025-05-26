package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements  UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<UserMission> findOngoingById(Long userId, Long missionId) {

        return userMissionRepository.findByUserIdAndMissionId(userId, missionId);
    }
}
