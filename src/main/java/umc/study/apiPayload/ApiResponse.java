package umc.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.status.SuccessStatus;

@Getter    // getter 자동 생성
@AllArgsConstructor     // 생성자 자동 생성
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")      // JSON에 isSuccess로 출력
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)  // result가 null이면 응답에서 제외
    private T result;


    // 성공한 경우 응답 생성

    // 기본 성공 응답
    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    // 응답 다양화
    public static <T> ApiResponse<T> of(BaseCode code, T result){
            return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        // 앞에 있는 <T>는 메서드 안에서 제네릭 타입을 사용하겠다는 의미. ApiResponse<T>가 리턴 타입
        return new ApiResponse<>(false, code, message, data);
    }
}
