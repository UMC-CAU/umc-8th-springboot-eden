package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");  // 멤버인 httpStatus, code, message에 대응하는 것으로 enum 상수 정의

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {  // httpStatus 제외...내부 처리용
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {    // 외부 응답용
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }

    /*
    * 지금은 두 메소드가 거의 비슷해서 구분이 무의미한 것 같지만,
    * 나중에 확장 시 구분이 필요할 수 있어 책임 분리 위한 것
    * */
}