package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.User;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}