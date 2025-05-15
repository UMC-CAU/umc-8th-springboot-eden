package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.enums.Gender;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Gender gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;  // 카테고리 선택 화면 렌더링 시 음식 카테고리를 조회하는 API를 호출하고,
                                    // 그 API의 결과에서 음식 카테고리의 id값을 프론트엔드가 넘겨준다는 것을 전제로 한 것
    }

}
