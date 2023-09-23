package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.dto.BadgeDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "학생이 획득한 뱃지리스트입니다")
public record BadgeAchievedDto(
        @Schema(description = "획득한 뱃지리스트입니다")
        List<BadgeDto> BadgeList
) {
}
