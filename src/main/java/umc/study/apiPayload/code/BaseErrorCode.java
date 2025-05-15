package umc.study.apiPayload.code;

// Status를 구체화하는 enum class에서 아래의 메소드들의 구현을 강제하기 위한 인터페이스
public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
