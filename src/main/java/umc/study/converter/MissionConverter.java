package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.math.BigDecimal;

public class MissionConverter {

    public static Mission toMissionEntity(MissionRequestDTO.CreateDTO request){

        return Mission.builder()
                .deadLine(request.getDeadline())
                .successAmount(request.getSuccessAmount())
                .rewardRatio(request.getRewardRatio())
                .build();
    }

    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission){
        // 성공 기준 금액에 보상 비율을 곱해 보상 포인트 계산 결과를 반환에 포함
        BigDecimal rewardRatio = mission.getSuccessAmount().multiply(mission.getRewardRatio());

        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .successAmount(mission.getSuccessAmount())
                .rewardAmount(rewardRatio)
                .createAt(mission.getCreatedAt())
                .updateAt(mission.getUpdatedAt())
                .build();
    }
}
