package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReviewEntity(ReviewRequestDTO.ReviewRestaurantDTO request){
        return Review.builder()
                .rating(request.getRating())
                .content(request.getContent())
                .build();
    }

    public static ReviewResponseDTO.ReviewRestaurantResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewRestaurantResultDTO.builder()
                .reviewId(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static ReviewResponseDTO.myReviewDTO toMyReviewDTO(Review review){
        return ReviewResponseDTO.myReviewDTO.builder()
                .restaurantName(review.getRestaurant().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public static ReviewResponseDTO.myReviewListDTO toMyReviewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.myReviewDTO> myReviewDTOList = reviewList.stream()
                .map(ReviewConverter::toMyReviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.myReviewListDTO.builder()
                .reviewList(myReviewDTOList)
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(myReviewDTOList.size())
                .build();
    }
}
