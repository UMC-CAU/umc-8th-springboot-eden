package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -200839606L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> deadLine = createDateTime("deadLine", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    public final StringPath info = createString("info");

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final EnumPath<umc.study.domain.enums.MissionStatus> missionStatus = createEnum("missionStatus", umc.study.domain.enums.MissionStatus.class);

    public final ListPath<Point, QPoint> pointList = this.<Point, QPoint>createList("pointList", Point.class, QPoint.class, PathInits.DIRECT2);

    public final QRestaurant restaurant;

    public final NumberPath<java.math.BigDecimal> rewardRatio = createNumber("rewardRatio", java.math.BigDecimal.class);

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    public final NumberPath<java.math.BigDecimal> successAmount = createNumber("successAmount", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission> userMissionList = this.<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission>createList("userMissionList", umc.study.domain.mapping.UserMission.class, umc.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final StringPath verifyCode = createString("verifyCode");

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

