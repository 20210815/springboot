package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;

public class TempHandler extends GeneralException{

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
