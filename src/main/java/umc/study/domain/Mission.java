package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserLike;
import umc.study.domain.mapping.UserMission;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    private LocalDateTime deadLine;

    @Column(nullable = false)
    private Integer successAmount;

    @Column(nullable = false)
    private double rewardRatio;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private MissionStatus missionStatus;

    @Column(length = 15)
    private String verifyCode;

    private Boolean isSuccess;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Point> pointList = new ArrayList<>();

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}
