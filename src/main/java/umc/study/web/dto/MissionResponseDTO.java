package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDTO{

        Long missionId;

        LocalDateTime deadline;

        BigDecimal successAmount;

        BigDecimal rewardAmount;

        LocalDateTime createAt;

        LocalDateTime updateAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class storeMissionDTO {
        String info;

        LocalDateTime deadLine;

        BigDecimal successAmount;

        BigDecimal rewardAmount;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class storeMissionListDTO {
        List<storeMissionDTO> missionList;

        Integer listSize;

        Integer totalPage;

        Long totalElements;

        Boolean isFirst;

        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myMissionDTO {
        String restaurantName;

        String restaurantCategory;

        String info;

        LocalDateTime deadLine;

        BigDecimal successAmount;

        BigDecimal rewardAmount;

        MissionStatus missionStatus;

        LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myMissionListDTO {
        List<myMissionDTO> missionList;

        Integer listSize;

        Integer totalPage;

        Long totalElements;

        Boolean isFirst;

        Boolean isLast;
    }
}
