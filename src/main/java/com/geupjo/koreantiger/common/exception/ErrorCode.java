package com.geupjo.koreantiger.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    LOGIN_INVALID("로그인 정보가 잘못되었습니다.", 100),
    PASSWORD_INVALID("비밀번호가 잘못되었습니다.", 101),
    //유저에러
    NO_MATCH_USER_EXCEPTION("존재하지않는 유저입니다.", 400),
    NOT_FOUND("요청된 정보를 찾을 수 없습니다.", 400);

    private final String message;
    private final int code;
}
