package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.service.RestaurantService.RestaurantQueryService;
import umc.study.validation.annotation.ExistRestaurants;

@Component
@RequiredArgsConstructor
public class RestaurantsExistValidator implements ConstraintValidator<ExistRestaurants, Long> {

    private final RestaurantQueryService restaurantQueryService;

    @Override
    public void initialize(ExistRestaurants constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {

        boolean isValid = restaurantQueryService.findStore(restaurantId).isPresent();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
