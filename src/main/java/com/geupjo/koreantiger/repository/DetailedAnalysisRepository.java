package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.DetailedAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailedAnalysisRepository extends JpaRepository<DetailedAnalysis, Long> {
    Optional<DetailedAnalysis> findByMemberId(long memberId);
}
