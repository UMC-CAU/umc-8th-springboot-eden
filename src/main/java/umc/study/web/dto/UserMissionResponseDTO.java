package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.ProgressStatus;

import java.time.LocalDateTime;

public class UserMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDTO {

        Long missionId;

        String restaurantName;

        MissionStatus missionStatus;

        LocalDateTime createdAt;

        LocalDateTime updatedAt;

    }

}
