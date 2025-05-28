package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.storeMissionDTO toStoreMissionDTO(Mission mission){
        return MissionResponseDTO.storeMissionDTO.builder()
                .info(mission.getInfo())
                .deadLine(mission.getDeadLine())
                .successAmount(mission.getSuccessAmount())
                .rewardAmount(mission.getSuccessAmount().multiply(mission.getRewardRatio()))
                .build();
    }

    public static MissionResponseDTO.storeMissionListDTO toStoreMissionListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.storeMissionDTO> storeMissionDTOList = missionList.stream()
                .map(MissionConverter::toStoreMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.storeMissionListDTO.builder()
                .missionList(storeMissionDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(storeMissionDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .build();
    }

    public static MissionResponseDTO.myMissionDTO toMyMissionDTO(Mission mission){
        return MissionResponseDTO.myMissionDTO.builder()
                .restaurantName(mission.getRestaurant().getName())
                .restaurantCategory(mission.getRestaurant().getCategory())
                .info(mission.getInfo())
                .deadLine(mission.getDeadLine())
                .successAmount(mission.getSuccessAmount())
                .rewardAmount(mission.getSuccessAmount().multiply(mission.getRewardRatio()))
                .missionStatus(mission.getMissionStatus())
                .updatedAt(mission.getUpdatedAt())
                .build();
    }

    public static MissionResponseDTO.myMissionListDTO toMyMissionListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.myMissionDTO> myMissionDTOList = missionList.stream()
                .map(MissionConverter::toMyMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.myMissionListDTO.builder()
                .missionList(myMissionDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(myMissionDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .build();
    }
}
