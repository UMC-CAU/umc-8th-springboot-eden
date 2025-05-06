package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOwnerInfo is a Querydsl query type for OwnerInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOwnerInfo extends EntityPathBase<OwnerInfo> {

    private static final long serialVersionUID = -959910081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOwnerInfo ownerInfo = new QOwnerInfo("ownerInfo");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    public final QRestaurant restaurant;

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QOwnerInfo(String variable) {
        this(OwnerInfo.class, forVariable(variable), INITS);
    }

    public QOwnerInfo(Path<? extends OwnerInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOwnerInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOwnerInfo(PathMetadata metadata, PathInits inits) {
        this(OwnerInfo.class, metadata, inits);
    }

    public QOwnerInfo(Class<? extends OwnerInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

