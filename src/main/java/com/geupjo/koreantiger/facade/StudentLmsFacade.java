package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.dto.TimeBox;
import com.geupjo.koreantiger.dto.response.*;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.MemberRepository;
import com.geupjo.koreantiger.service.StudentLmsService;
import com.geupjo.koreantiger.util.ContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentLmsFacade {

    private final StudentLmsService studentLmsService;
    private final MemberRepository memberRepository;

    public StudentProfileResponseDto getStudentProfile(Long studentId) {
        return studentLmsService.getStudentProfile(studentId);
    }

    public RankingBoardResponseDto getRankingBoard(Long studentId) {
        return studentLmsService.getRankingBoard(studentId);
    }

    public StudentHistoryResponseDto getStudentEducationHistories() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return studentLmsService.getStudentEducationHistories(currentStudent);
    }

    public StudentCheckInDto getStudentCheckIn() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return studentLmsService.getStudentCheckIn(currentStudent);
    }

    public BiWeeklyAchievementResponseDto getWeeklyAchievement() {
        Member currentStudent = ContextUtils.loadMockStudent();
        TimeBox timeBox = TimeBox.getItem();
        return studentLmsService.getWeeklyAchievement(currentStudent, timeBox);
    }
}
