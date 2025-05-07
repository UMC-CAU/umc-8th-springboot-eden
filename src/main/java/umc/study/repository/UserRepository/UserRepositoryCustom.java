package umc.study.repository.UserRepository;

import com.querydsl.core.Tuple;

import java.util.List;

public interface UserRepositoryCustom  {
    List<Tuple> getMyPageInfo(Long userId);
}
