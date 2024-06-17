package com.th.board.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{
    UPLOAD_FAIL(HttpStatus.BAD_REQUEST, "이미지 파일이 아닙니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
