package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.ExistPage;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    private final MissionQueryService missionQueryService;

    @PostMapping("/restaurants/{restaurantId}/mission")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @PathVariable Long restaurantId,
            @RequestBody @Valid MissionRequestDTO.CreateDTO request) {

        Mission mission = missionCommandService.create(restaurantId, request);

        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }

    @GetMapping("/restaurants/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "pageNumber", description = "페이지 넘버, query string 입니다. 1부터 시작입니다.")
    })
    public ApiResponse<MissionResponseDTO.storeMissionListDTO> getAllByRestaurantByPage(
           @PathVariable Long restaurantId,
           @ExistPage @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber) {

        Page<Mission> missionList = missionQueryService.getByRestaurantByPage(restaurantId, pageNumber-1, 10);

        return ApiResponse.onSuccess(MissionConverter.toStoreMissionListDTO(missionList));

    }
}
