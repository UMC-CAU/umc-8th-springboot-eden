package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;

    private final MissionRepository missionRepository;

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMission createUserMission(Long missionId) {

        // 유저 찾기(임시 하드코딩)
        User myUserObj = userRepository.findById(1L).orElse(null);

        // 도전하려는 미션 찾기
        Mission selectedMission = missionRepository.findById(missionId).orElse(null);

        // 새로운 유저-미션 관계 형성
        UserMission newUserMission = UserMission.builder()
                .user(myUserObj)
                .mission(selectedMission)
                .missionStatus(MissionStatus.ONGOING)
                .build();

        myUserObj.addUserMission(newUserMission);   // 유저와 유저미션 1:다 연결
        selectedMission.addUserMission(newUserMission);     // 미션과 유저미션 1:다 연결

        return userMissionRepository.save(newUserMission);
    }
}
