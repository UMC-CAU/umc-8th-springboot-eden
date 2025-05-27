package umc.study.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findStore(Long id);
    List<Restaurant> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
