package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.validation.annotation.IngMission;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionIngValidator implements ConstraintValidator<IngMission, Long> {

    private final UserMissionQueryService userMissionQueryService;

    @Override
    public void initialize(IngMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        boolean isOngoing = userMissionQueryService.findOngoingById(1L, missionId)  // 유저 정보는 하드 코딩
                .map(userMission -> userMission.getMissionStatus().equals(MissionStatus.ONGOING))
                .orElse(false);


        if (isOngoing) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ONGOING.toString()).addConstraintViolation();
        }

        return !isOngoing;
    }
}
