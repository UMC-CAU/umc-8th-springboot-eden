package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.mapping.UserMission;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.validation.annotation.IngMission;
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
}
