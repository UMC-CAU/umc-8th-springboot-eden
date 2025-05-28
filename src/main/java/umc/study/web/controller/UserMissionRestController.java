package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.mapping.UserMission;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.validation.annotation.IngMission;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/mission/{missionId}/join")
    public ApiResponse<UserMissionResponseDTO.JoinDTO> joinUserMission(
           @IngMission @PathVariable Long missionId
    ) {
        UserMission userMission = userMissionCommandService.createUserMission(missionId);

        return ApiResponse.onSuccess(UserMissionConverter.toCreateUserMissionResultDTO(userMission));
    }

    @PatchMapping("/missions/complete")
    @Operation(summary = "진행 중 미션 완료 처리 API",description = "진행 중인 미션을 완료 처리하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공")
    })
    public ApiResponse<UserMissionResponseDTO.completeResultDTO> completeMission(
            @RequestBody @Valid UserMissionRequestDTO.completeDTO request
            ){
        UserMission userMission = userMissionCommandService.completeMission(request.getMissionId(), request.getVerifyCode());

        return ApiResponse.onSuccess(UserMissionConverter.toCompleteResultDTO(userMission));
    }
}
