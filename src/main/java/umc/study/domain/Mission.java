package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserLike;
import umc.study.domain.mapping.UserMission;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(columnDefinition = "TEXT")
    private String info;

    private LocalDateTime deadLine;

    @Column(precision = 10, scale = 1, nullable = false)
    private BigDecimal successAmount;

    @Column(precision = 5, scale = 4, nullable = false)
    private BigDecimal rewardRatio;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ONGOING'")
    private MissionStatus missionStatus = MissionStatus.ONGOING;

    @Column(length = 15)
    private String verifyCode;

    private Boolean isSuccess;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Point> pointList = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    public void addUserMission(UserMission userMission){
        this.userMissionList.add(userMission);
        userMission.setMission(this);
    }
}
