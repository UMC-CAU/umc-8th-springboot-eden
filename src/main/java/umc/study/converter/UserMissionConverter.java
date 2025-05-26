package umc.study.converter;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.JoinDTO toCreateUserMissionResultDTO(UserMission userMission) {

        return UserMissionResponseDTO.JoinDTO.builder()
                .missionId(userMission.getMission().getId())
                .restaurantName(userMission.getMission().getRestaurant().getName())
                .missionStatus(userMission.getMissionStatus())
                .createdAt(userMission.getCreatedAt())
                .updatedAt(userMission.getUpdatedAt())
                .build();

    }
}
