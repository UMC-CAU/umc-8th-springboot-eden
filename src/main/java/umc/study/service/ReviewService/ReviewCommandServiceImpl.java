package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    @Override
    public Review reviewRestaurant(Long restaurantId, ReviewRequestDTO.ReviewRestaurantDTO request) {

        // 전달받은 정보 바탕으로 리뷰 생성
        Review newReview = ReviewConverter.toReviewEntity(request);

        // user 정보 추가(원래 로그인을 통해 정보를 받아오지만 구현이 안되어있기에 하드코딩으로 대체)
        User myUserObj = userRepository.findById(1L).orElse(null);
        newReview.setUser(myUserObj);

        // id로 식당 객체 찾아서 연관관계 매핑
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);    // Todo: 예외 처리 필요
        newReview.setRestaurant(restaurant);

        return reviewRepository.save(newReview);
    }
}
