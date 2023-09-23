package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.BadgeAchieved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeAchievedRepository extends JpaRepository<BadgeAchieved, Long> {
    List<BadgeAchieved> findAllByMemberId(Long memberId);
}
