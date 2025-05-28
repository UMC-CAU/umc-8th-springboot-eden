package umc.study.web.dto;

import lombok.Getter;

public class UserMissionRequestDTO {
    @Getter
    public static class completeDTO{

        Long missionId;

        String verifyCode;
    }
}
