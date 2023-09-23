package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.common.exception.CustomException;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import com.geupjo.koreantiger.dto.response.AreaAnalysisDto;
import com.geupjo.koreantiger.entity.DetailedAnalysis;
import com.geupjo.koreantiger.entity.Member;
import com.geupjo.koreantiger.repository.DetailedAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailedLmsService {
    private final DetailedAnalysisRepository detailedAnalysisRepository;

    public AreaAnalysisDto getAreaAnalysis(Member currentStudent) {
        DetailedAnalysis detailedAnalysis = detailedAnalysisRepository.findByMemberId(currentStudent.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.NO_MATCH_USER_EXCEPTION));
        return new AreaAnalysisDto(detailedAnalysis.getGrammar(),
                detailedAnalysis.getAssignment(),
                detailedAnalysis.getAlgorithm(),
                detailedAnalysis.getRecursive(),
                detailedAnalysis.getString(),
                detailedAnalysis.getTotal());
    }
}
