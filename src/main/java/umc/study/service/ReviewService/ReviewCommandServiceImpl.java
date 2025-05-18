package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Review reviewRestaurant(Long restaurantId, ReviewRequestDTO.ReviewRestaurantDTO request) {

        // 전달받은 정보 바탕으로 리뷰 생성
        Review newReview = ReviewConverter.toReviewEntity(request);

        // id로 식당 객체 찾아서 연관관계 매핑
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);    // Todo: 예외 처리 필요
        newReview.setRestaurant(restaurant);

        return reviewRepository.save(newReview);
    }
}
