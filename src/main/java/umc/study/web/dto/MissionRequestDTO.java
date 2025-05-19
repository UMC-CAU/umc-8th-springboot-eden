package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO{

        @NotNull(message = "기한을 입력하세요")
        LocalDateTime deadline;

        @NotNull(message = "성공 기준 금액을 입력하세요")
        BigDecimal successAmount;

        @NotNull(message = "보상 비율을 입력하세요")
        BigDecimal rewardRatio;
    }
}
