package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository;

public class ReviewQueryServiceImpl implements ReviewQueryService {

    private UserRepository userRepository;

    private ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewByPage(int number, int size) {

        User myUserObj = userRepository.findById(1L).get();

        return reviewRepository.findAllByUser(myUserObj, PageRequest.of(number, 10));
    }
}
