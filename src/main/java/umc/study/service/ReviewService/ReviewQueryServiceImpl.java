package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewByPage(int number, int size) {

        User myUserObj = userRepository.findById(1L).orElse(null);

        return reviewRepository.findAllByUser(myUserObj, PageRequest.of(number, 10));
    }
}
