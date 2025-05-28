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
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.ExistRestaurants;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/restaurants")     // restaurant에 종속되기에 상위 계층을 통합
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    private final ReviewQueryService reviewQueryService;

    @PostMapping("/restaurants/{restaurantId}/review")
    public ApiResponse<ReviewResponseDTO.ReviewRestaurantResultDTO> reviewRestaurant(
            @ExistRestaurants @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewRestaurantDTO request) {

        Review review = reviewCommandService.reviewRestaurant(restaurantId, request);

        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

    @GetMapping("/reviews/my")
    @Operation(summary = "내가 작성한 리뷰 조회 API",description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "pageNumber", description = "페이지 넘버, query string 입니다. 1부터 시작입니다.")
    })
    public ApiResponse<ReviewResponseDTO.myReviewListDTO> getMyReviews(
            @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber
    ){
        Page<Review> reviewList = reviewQueryService.getReviewByPage(pageNumber-1, 10);

        return ApiResponse.onSuccess(ReviewConverter.toMyReviewListDTO(reviewList));
    }


}
