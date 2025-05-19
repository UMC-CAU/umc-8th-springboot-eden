package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission create(Long restaurantId, MissionRequestDTO.CreateDTO request);
}
