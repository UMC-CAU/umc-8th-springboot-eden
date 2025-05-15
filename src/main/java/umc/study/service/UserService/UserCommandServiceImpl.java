package umc.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodLikeHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserLikeConverter;
import umc.study.domain.FoodLike;
import umc.study.domain.User;
import umc.study.domain.mapping.UserLike;
import umc.study.repository.FoodLikeRepository.FoodLikeRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    private final FoodLikeRepository foodLikeRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request){

        User newUser = UserConverter.toUser(request);
        List<FoodLike> foodLikeList = request.getPreferCategory().stream()
                .map(category -> {
            return foodLikeRepository.findById(category).orElseThrow(() -> new FoodLikeHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        }).collect(Collectors.toList());

        List<UserLike> userLikeList = UserLikeConverter.toUserLikeList(foodLikeList);

        userLikeList.forEach(userLike -> {userLike.setUser(newUser);});

        return userRepository.save(newUser);


    }
}
