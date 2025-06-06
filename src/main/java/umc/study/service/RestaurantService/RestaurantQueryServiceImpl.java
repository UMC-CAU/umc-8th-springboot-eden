package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Restaurant> findStore(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findStoresByNameAndScore(String name, Float score) {
        List<Restaurant> filteredStores = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(StoreId).get();

        Page<Review> RestaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return RestaurantPage;
    }
}
