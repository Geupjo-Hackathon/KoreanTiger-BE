package com.geupjo.koreantiger.dto;

import com.geupjo.koreantiger.enums.Badge;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record BadgeDto(
        @Schema(description = "뱃지코드")
        Badge badgeCode,

        @Schema(description = "뱃지이름")
        String badgeName,

        @Schema(description = "뱃지설명")
        String badgeDescription,

        @Schema(description = "뱃지획득일")
        LocalDateTime badgeEarnedPeriod
) {
}
