package umc.study.repository.RestaurantRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QRestaurant;
import umc.study.domain.Restaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant restaurant = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(restaurant.name.eq(name));
        }

        if (score != null) {
            predicate.and(restaurant.rating.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();
    }
}
