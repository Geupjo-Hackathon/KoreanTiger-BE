package com.geupjo.koreantiger.dto.response;

import com.geupjo.koreantiger.dto.TimeBox;
import com.geupjo.koreantiger.dto.WeeklyAchievement;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Map;

public record BiWeeklyAchievementResponseDto(
        @Schema(description = "지난주 학습 이력")
        AchievementItem lastWeek,

        @Schema(description = "이번주 학습 이력")
        AchievementItem thisWeek,

        @Schema(description = "날짜")
        LocalDate date
) {
    public static BiWeeklyAchievementResponseDto of(Map<Integer, WeeklyAchievement> weeklyAchievement, TimeBox timeBox) {
        AchievementItem lastWeek = AchievementItem.of(weeklyAchievement.get(timeBox.lastWeekOfMonth()));
        AchievementItem thisWeek = AchievementItem.of(weeklyAchievement.get(timeBox.thisWeekOfMonth()));
        LocalDate date = LocalDate.now();

        return new BiWeeklyAchievementResponseDto(lastWeek, thisWeek, date);
    }

    private record AchievementItem(
            @Schema(description = "주차", example = "1")
            int weekOfMonth,

            @Schema(description = "총 학습시간(분)", example = "100")
            long totalLearningTime,

            @Schema(description = "총 완강 강의 수", example = "10")
            long completeLectureCount
    ) {
        private static AchievementItem of(WeeklyAchievement weeklyAchievement) {
            return new AchievementItem(
                    weeklyAchievement.weekOfMonth(),
                    weeklyAchievement.learningTime(),
                    weeklyAchievement.lectureCount()
            );
        }
    }
}
