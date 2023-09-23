package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.dto.TimeBox;
import com.geupjo.koreantiger.dto.response.*;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.MemberService;
import com.geupjo.koreantiger.service.StudentLmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentLmsFacade {

    private final MemberService memberService;
    private final StudentLmsService studentLmsService;

    public StudentProfileResponseDto getStudentProfile() {
        Member student = getStudent();
        return studentLmsService.getStudentProfile(student);
    }

    public RankingBoardResponseDto getRankingBoard() {
        Member student = getStudent();
        return studentLmsService.getRankingBoard(student);
    }

    public StudentHistoryResponseDto getStudentEducationHistories() {
        Member currentStudent = getStudent();
        return studentLmsService.getStudentEducationHistories(currentStudent);
    }

    public StudentCheckInDto getStudentCheckIn() {
        Member currentStudent = getStudent();
        return studentLmsService.getStudentCheckIn(currentStudent);
    }

    public BiWeeklyAchievementResponseDto getWeeklyAchievement() {
        Member currentStudent = getStudent();
        TimeBox timeBox = TimeBox.getItem();
        return studentLmsService.getWeeklyAchievement(currentStudent, timeBox);
    }

    public BadgeAchievedDto getBadgeAchievement() {
        Member currentStudent = getStudent();
        return studentLmsService.getBadgeAchievement(currentStudent);
    }

    private Member getStudent() {
        return memberService.findById(268L);
    }
}
