package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.StudentProfileTitle;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class EducationProfile extends BaseEntity {
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int experience;

    @Min(1)
    @Max(100)
    @Column
    private int level;

    @Column(nullable = false)
    private long memberId;

    @Column(nullable = false)
    private long detailedAnalysisId;

    @Column(nullable = false)
    private String lastEducation;

    @Column(nullable = false)
    private double progress;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentProfileTitle studentProfileTitle;

    public EducationProfile(int experience, int level, long memberId, long detailedAnalysisId, String lastEducation, double progress, StudentProfileTitle studentProfileTitle) {
        this.experience = experience;
        this.level = level;
        this.memberId = memberId;
        this.detailedAnalysisId = detailedAnalysisId;
        this.lastEducation = lastEducation;
        this.progress = progress;
        this.studentProfileTitle = studentProfileTitle;
    }
}
