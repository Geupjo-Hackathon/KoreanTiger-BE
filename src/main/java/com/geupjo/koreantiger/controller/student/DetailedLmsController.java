package com.geupjo.koreantiger.controller.student;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.AreaAnalysisDto;
import com.geupjo.koreantiger.facade.DetailedLmsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DetailedLmsController", description = "학생 LMS 창에 들어가는 기능 api입니다")
@RequestMapping("/v1/DetailedLms")
@RestController
@RequiredArgsConstructor
public class DetailedLmsController {

    private final DetailedLmsFacade detailedLmsFacade;

    @Operation(summary = "영역별 분석")
    @GetMapping("/area-analysis")
    public ApiResponse<AreaAnalysisDto> areaAnalysis() {
        AreaAnalysisDto response = detailedLmsFacade.getAreaAnalysis();
        return ApiResponse.success(response);
    }
}
