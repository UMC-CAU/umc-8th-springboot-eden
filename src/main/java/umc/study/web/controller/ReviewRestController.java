package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistRestaurants;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")     // restaurant에 종속되기에 상위 계층을 통합
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{restaurantId}/review")
    public ApiResponse<ReviewResponseDTO.ReviewRestaurantResultDTO> reviewRestaurant(
            @ExistRestaurants @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewRestaurantDTO request) {

        Review review = reviewCommandService.reviewRestaurant(restaurantId, request);

        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }


}
