package com.geupjo.koreantiger.repository;

import com.geupjo.koreantiger.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findByStudentId(Long studentId);

    List<Class> findAllByClassInfoId(Long classId);
}
