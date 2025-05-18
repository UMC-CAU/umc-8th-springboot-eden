package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;

public class MissionConverter {

    public static Mission toMissionEntity(MissionRequestDTO.CreateDTO request){

        return Mission.builder()
                .deadLine(request.getDeadline())
                .successAmount(request.getSuccessAmount())
                .rewardRatio(request.getRewardRatio())
                .build();
    }
}
