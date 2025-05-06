package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodLike is a Querydsl query type for FoodLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodLike extends EntityPathBase<FoodLike> {

    private static final long serialVersionUID = -345015273L;

    public static final QFoodLike foodLike = new QFoodLike("foodLike");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath category = createString("category");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserLike, umc.study.domain.mapping.QUserLike> userLikeList = this.<umc.study.domain.mapping.UserLike, umc.study.domain.mapping.QUserLike>createList("userLikeList", umc.study.domain.mapping.UserLike.class, umc.study.domain.mapping.QUserLike.class, PathInits.DIRECT2);

    public QFoodLike(String variable) {
        super(FoodLike.class, forVariable(variable));
    }

    public QFoodLike(Path<? extends FoodLike> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodLike(PathMetadata metadata) {
        super(FoodLike.class, metadata);
    }

}

