package com.geupjo.koreantiger.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "영역별분석 육각그래프를 값입니다")
public record AreaAnalysisDto(
        @Schema(description = "문법 xx%")
        int grammar,

        @Schema(description = "과제 xx%")
        int assignment,

        @Schema(description = "알고리즘 xx%")
        int algorithm,

        @Schema(description = "재귀 xx%")
        int recursive,

        @Schema(description = "문자열 xx%")
        int string,

        @Schema(description = "종합 xx%")
        int total
) {
}
