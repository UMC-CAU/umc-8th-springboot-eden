package umc.study.repository.MissionRepository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QRestaurant;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.ProgressStatus;
import umc.study.domain.mapping.QUserMission;

import java.util.List;

public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission m = QMission.mission;
    private final QRestaurant r = QRestaurant.restaurant;
    private final QUserMission um = QUserMission.userMission;

    public MissionRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Tuple> getMyOngoingMissions(Long userId, String cursorValue) {
        StringTemplate cursorExpr = Expressions.stringTemplate(
                "CONCAT({0}, LPAD({1}, 10, '0'))", m.deadLine, m.id
        );

        return jpaQueryFactory
                .select(m.id, m.successAmount, m.rewardRatio, m.verifyCode, r.name, cursorExpr)
                .from(m)
                .join(m.restaurant, r)
                .where(
                        m.id.in(
                                JPAExpressions
                                        .select(um.mission.id)
                                        .from(um)
                                        .where(
                                                um.user.id.eq(userId),
                                                um.missionStatus.in(MissionStatus.SUCCEEDED, MissionStatus.FAILED)
                                        )
                        )
                        ,cursorExpr.gt(cursorValue)
                )
                .orderBy(m.deadLine.asc(), m.id.asc())
                .limit(5)
                .fetch();

    }

    @Override
    public List<Tuple> getMyCompletedMissions(Long userId, String cursorValue) {
        StringTemplate cursorExpr = Expressions.stringTemplate(
                "CONCAT({0}, LPAD({1}, 10, '0'))", um.updatedAt, m.id
        );

        return jpaQueryFactory
                .select(m.id, m.successAmount, m.rewardRatio, um.missionStatus, r.name, cursorExpr)
                .from(m)
                .join(m.restaurant, r)
                .join(um).on(um.mission.eq(m))
                .where(
                        um.user.id.eq(userId),
                        um.missionStatus.in(MissionStatus.SUCCEEDED, MissionStatus.FAILED),
                        cursorExpr.lt(cursorValue)
                )
                .orderBy(um.updatedAt.desc(), m.id.desc())
                .limit(5)
                .fetch();
    }

    @Override
    public List<Tuple> getInfoForHome(Long userId, Long regionId, String cursorValue) {
        StringTemplate cursorExpr = Expressions.stringTemplate(
                "CONCAT({0}, LPAD({1}, 10, '0'))", m.deadLine, m.id
        );

        return jpaQueryFactory
                .select(m.id, m.deadLine, m.successAmount, m.rewardRatio, r.name, r.category, cursorExpr)
                .from(m)
                .leftJoin(um).on(
                        um.mission.eq(m),
                        um.user.id.eq(userId)
                )
                .join(m.restaurant, r)
                .where(
                        (um.user.id.isNull().or(um.missionStatus.in(MissionStatus.SUCCEEDED, MissionStatus.FAILED))),
                        r.region.id.eq(regionId),
                        cursorExpr.gt(cursorValue)
                )
                .orderBy(m.deadLine.asc(), m.id.asc())
                .limit(5)
                .fetch();
    }
}
