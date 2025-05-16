package umc.study.converter;

import umc.study.domain.FoodLike;
import umc.study.domain.mapping.UserLike;

import java.util.List;
import java.util.stream.Collectors;

public class UserLikeConverter {

    public static List<UserLike> toUserLikeList(List<FoodLike> foodLikeList){

        return foodLikeList.stream()
                .map(foodLike ->
                        UserLike.builder()
                                .foodLike(foodLike)
                                .build()
                ).collect(Collectors.toList());
    }
}
