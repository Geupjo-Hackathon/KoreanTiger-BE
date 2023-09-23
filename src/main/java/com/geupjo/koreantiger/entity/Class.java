package com.geupjo.koreantiger.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(schema = "geupjo")
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long studentId;

    @Column(nullable = false)
    private long teacherId;

    @Column(nullable = false)
    private long classInfoId;

    @Column(nullable = false)
    private long institutionId;

    public Class(long studentId, long teacherId, long classInfoId, long institutionId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.classInfoId = classInfoId;
        this.institutionId = institutionId;
    }
}
