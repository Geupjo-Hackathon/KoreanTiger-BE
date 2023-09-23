package com.geupjo.koreantiger.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "학생 프로필 응답DTO 입니다")
public record StudentProfileResponseDto(
        @Schema(description = "학생이름")
        String name,

        @Schema(description = "경험치")
        int experience,

        @Schema(description = "xx일 연속접속 일자")
        int connection,

        @Schema(description = "칭호 ex) 코드입문자")
        String title
) {
}
