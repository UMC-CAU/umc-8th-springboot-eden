package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission,Long> {

    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);

    Page<UserMission> findByUserAndMissionStatus(User user, MissionStatus missionStatus, Pageable pageable);
}
