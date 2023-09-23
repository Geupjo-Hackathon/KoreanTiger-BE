package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoRepository extends JpaRepository<ClassInfo, Long> {
}
