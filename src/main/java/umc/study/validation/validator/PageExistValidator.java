package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.ExistPage;

@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<ExistPage, Integer> {

    @Override
    public void initialize(ExistPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer pageNumber, ConstraintValidatorContext context) {

        boolean isValid = !(pageNumber == null || pageNumber<=0) ;

        if ( !isValid ) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
