package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.User;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    Page<Mission> findAllByUser(User user, PageRequest pageRequest);
}
