package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.validation.annotation.IngMission;

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

        boolean isOngoing = userMissionQueryService.findOngoingById(1L, missionId).isPresent();   // 유저 정보는 하드 코딩

        if (isOngoing) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ONGOING.toString()).addConstraintViolation();
        }

        return !isOngoing;
    }
}
