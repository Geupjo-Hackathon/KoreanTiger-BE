package com.geupjo.koreantiger.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LearningTimeGrade {
    NONE(0),
    LOW(1),
    MIDDLE(2),
    HIGH(3),
    VERY_HIGH(4);

    private final long value;

    public static LearningTimeGrade convert(long learningTime) {
        if (learningTime == 0) {
            return NONE;
        } else if (learningTime >= 20 && learningTime < 40) {
            return LOW;
        } else if (learningTime >= 40 && learningTime < 60) {
            return MIDDLE;
        } else if (learningTime >= 60 && learningTime < 80) {
            return HIGH;
        } else {
            return VERY_HIGH;
        }
    }
}
