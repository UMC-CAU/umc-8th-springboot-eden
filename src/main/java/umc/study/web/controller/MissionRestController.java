package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/restaurants/{restaurantId}/mission")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @PathVariable Long restaurantId,
            @RequestBody @Valid MissionRequestDTO.CreateDTO request) {

        Mission mission = missionCommandService.create(restaurantId, request);

        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
