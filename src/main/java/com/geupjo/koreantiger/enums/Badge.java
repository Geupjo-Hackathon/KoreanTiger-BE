package com.geupjo.koreantiger.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Badge {
    PERFECTATTENDANCE("개근상", "30일 이상 빠지지않고 접속"),
    GRAMMARMASTER("문법마스터", "문법카테고리 평가점수에서 90점이상 달성"),
    ASSIGNMENTKING("과제왕", "과제완료 누적 50개 달성"),
    HUGEGROUWH("엄청난상승", "평가점수 상승총합 50점이상"),
    OUTSTANDING("뛰어난학생", "모든평가 점수 90점이상");


    private final String badgeName;

    private final String description;
}
