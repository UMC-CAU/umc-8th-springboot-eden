package umc.study.converter;

import umc.study.domain.User;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;
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

    public static UserMissionResponseDTO.completeResultDTO toCompleteResultDTO(UserMission userMission) {

        return UserMissionResponseDTO.completeResultDTO.builder()
                .restaurantId(userMission.getMission().getRestaurant().getId())
                .missionId(userMission.getMission().getId())
                .rewardAmount(userMission.getMission().getSuccessAmount().multiply(userMission.getMission().getRewardRatio()))
                .missionStatus(userMission.getMissionStatus())
                .updatedAt(userMission.getUpdatedAt())
                .build();
    }
}
