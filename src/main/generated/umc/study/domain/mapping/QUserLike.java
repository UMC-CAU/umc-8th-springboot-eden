package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserLike is a Querydsl query type for UserLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserLike extends EntityPathBase<UserLike> {

    private static final long serialVersionUID = 390511652L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserLike userLike = new QUserLike("userLike");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFoodLike foodLike;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QUserLike(String variable) {
        this(UserLike.class, forVariable(variable), INITS);
    }

    public QUserLike(Path<? extends UserLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserLike(PathMetadata metadata, PathInits inits) {
        this(UserLike.class, metadata, inits);
    }

    public QUserLike(Class<? extends UserLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodLike = inits.isInitialized("foodLike") ? new umc.study.domain.QFoodLike(forProperty("foodLike")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

