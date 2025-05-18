package umc.study.web.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO{

        LocalDateTime deadline;

        BigDecimal successAmount;

        BigDecimal rewardRatio;
    }
}
