package com.geupjo.koreantiger.facade;

import com.geupjo.koreantiger.dto.response.AreaAnalysisDto;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.service.DetailedLmsService;
import com.geupjo.koreantiger.util.ContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DetailedLmsFacade {

    private final DetailedLmsService detailedLmsService;

    public AreaAnalysisDto getAreaAnalysis() {
        Member currentStudent = ContextUtils.loadMockStudent();
        return detailedLmsService.getAreaAnalysis(currentStudent);
    }
}
