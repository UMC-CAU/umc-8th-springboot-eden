package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission,Long> {

    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);
}
