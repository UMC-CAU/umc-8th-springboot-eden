package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class FoodLikeHandler extends GeneralException {

    public FoodLikeHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
