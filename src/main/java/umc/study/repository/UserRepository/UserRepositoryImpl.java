package umc.study.repository.UserRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.study.domain.QUser;

import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser u = QUser.user;

    public UserRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Tuple> getMyPageInfo(Long userId) {
        return jpaQueryFactory
                .select(u.id, u.email, u.nickname, u.phoneNumber, u.phoneVerified, u.point)
                .from(u)
                .where(
                        u.id.eq(userId)
                )
                .fetch();
    }
}
