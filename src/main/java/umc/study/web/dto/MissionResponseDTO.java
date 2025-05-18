package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}
