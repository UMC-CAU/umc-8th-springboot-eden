package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 479029197L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactiveAt = _super.inactiveAt;

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final QOwnerInfo ownerInfo;

    public final StringPath phoneNumber = createString("phoneNumber");

    public final BooleanPath phoneVerified = createBoolean("phoneVerified");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Point, QPoint> pointList = this.<Point, QPoint>createList("pointList", Point.class, QPoint.class, PathInits.DIRECT2);

    public final StringPath refreshToken = createString("refreshToken");

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final ListPath<ReviewReply, QReviewReply> reviewReplyList = this.<ReviewReply, QReviewReply>createList("reviewReplyList", ReviewReply.class, QReviewReply.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.SocialType> socialType = createEnum("socialType", umc.study.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    //inherited
    public final EnumPath<umc.study.domain.enums.Status> status = _super.status;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree> userAgreeList = this.<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree>createList("userAgreeList", umc.study.domain.mapping.UserAgree.class, umc.study.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserLike, umc.study.domain.mapping.QUserLike> userLikeList = this.<umc.study.domain.mapping.UserLike, umc.study.domain.mapping.QUserLike>createList("userLikeList", umc.study.domain.mapping.UserLike.class, umc.study.domain.mapping.QUserLike.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission> userMissionList = this.<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission>createList("userMissionList", umc.study.domain.mapping.UserMission.class, umc.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.UserType> userType = createEnum("userType", umc.study.domain.enums.UserType.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ownerInfo = inits.isInitialized("ownerInfo") ? new QOwnerInfo(forProperty("ownerInfo"), inits.get("ownerInfo")) : null;
    }

}

