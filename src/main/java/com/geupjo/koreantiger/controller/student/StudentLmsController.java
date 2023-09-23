package com.geupjo.koreantiger.controller.student;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.*;
import com.geupjo.koreantiger.facade.StudentLmsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "StudentLmsController", description = "학생 LMS 창에 들어가는 기능 api입니다")
@RequestMapping("/v1/studentLms")
@RestController
@RequiredArgsConstructor
public class StudentLmsController {

    private final StudentLmsFacade studentLmsFacade;

    @Operation(summary = "학생프로필 api 입니다")
    @GetMapping("/experience")
    public ApiResponse<StudentProfileResponseDto> studentProfileResponse() {
        StudentProfileResponseDto response = studentLmsFacade.getStudentProfile();
        return ApiResponse.success(response);
    }

    @Operation(summary = "랭킹보드 api 입니다")
    @GetMapping("/ranking")
    public ApiResponse<RankingBoardResponseDto> studentRankingResponse() {
        RankingBoardResponseDto response = studentLmsFacade.getRankingBoard();
        return ApiResponse.success(response);
    }

    @Operation(summary = "학생의 지난 1달간 학습 이력")
    @GetMapping("/histories")
    public ApiResponse<StudentHistoryResponseDto> studentEducationHistories() {
        StudentHistoryResponseDto response = studentLmsFacade.getStudentEducationHistories();
        return ApiResponse.success(response);
    }

    @Operation(summary = "프로필 출석체크 조회")
    @GetMapping("/check-in")
    public ApiResponse<StudentCheckInDto> studentCheckIn() {
        StudentCheckInDto response = studentLmsFacade.getStudentCheckIn();
        return ApiResponse.success(response);
    }

    @Operation(summary = "주간 나의 성취도")
    @GetMapping("/achievement")
    public ApiResponse<BiWeeklyAchievementResponseDto> studentWeeklyAchievement() {
        BiWeeklyAchievementResponseDto response = studentLmsFacade.getWeeklyAchievement();
        return ApiResponse.success(response);
    }

    @Operation(summary = "획득 뱃지 조회")
    @GetMapping("/badge-achieved")
    public ApiResponse<BadgeAchievedDto> badgeAchievement() {
        BadgeAchievedDto response = studentLmsFacade.getBadgeAchievement();
        return ApiResponse.success(response);
    }
}
