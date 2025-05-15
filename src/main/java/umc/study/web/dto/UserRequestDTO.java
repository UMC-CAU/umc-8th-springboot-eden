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
        List<Long> preferCategory;
    }

}
