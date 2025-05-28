package umc.study.service.UserMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionQueryService {

    Optional<UserMission> findOngoingById(Long userId, Long missionId);
    Page<UserMission> getByUserByStatusByPage(Long userId, MissionStatus missionStatus, int number, int size);
}
