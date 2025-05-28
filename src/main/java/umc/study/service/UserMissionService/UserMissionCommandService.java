package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;

public interface UserMissionCommandService {

    UserMission createUserMission(Long missionId);

    UserMission completeMission(Long missionId, String verifyCode);
}
