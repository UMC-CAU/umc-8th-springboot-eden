package umc.study.repository.FoodLikeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodLike;

public interface FoodLikeRepository extends JpaRepository<FoodLike,Long> {
}
