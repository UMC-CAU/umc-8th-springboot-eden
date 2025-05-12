package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
* 하나의 핵심 개념과 관련된 DTO들을 하나의 클래스에서 함께 정의한다.
* 해당 클래스의 인스턴스 없이도 생성 및 사용이 가능하게 static으로 선언
* */
public class TempResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        String testString;
    }
}
