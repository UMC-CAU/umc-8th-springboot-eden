package umc.study.repository.MissionRepository;

import com.querydsl.core.Tuple;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Tuple> getMyOngoingMissions(Long userId, String cursorValue);
    List<Tuple> getMyCompletedMissions(Long userId, String cursorValue);
    List<Tuple> getInfoForHome(Long userId, Long regionId, String cursorValue);
}
