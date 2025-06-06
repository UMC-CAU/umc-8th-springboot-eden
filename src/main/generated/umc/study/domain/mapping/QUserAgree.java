package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAgree is a Querydsl query type for UserAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAgree extends EntityPathBase<UserAgree> {

    private static final long serialVersionUID = -789252161L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAgree userAgree = new QUserAgree("userAgree");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    public final umc.study.domain.QTerm term;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QUserAgree(String variable) {
        this(UserAgree.class, forVariable(variable), INITS);
    }

    public QUserAgree(Path<? extends UserAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAgree(PathMetadata metadata, PathInits inits) {
        this(UserAgree.class, metadata, inits);
    }

    public QUserAgree(Class<? extends UserAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.term = inits.isInitialized("term") ? new umc.study.domain.QTerm(forProperty("term")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

