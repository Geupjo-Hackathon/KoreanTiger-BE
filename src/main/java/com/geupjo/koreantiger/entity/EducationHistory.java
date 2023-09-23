package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.LearningTimeGrade;
import com.geupjo.koreantiger.util.TimeUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class EducationHistory extends BaseEntity {

    @Column
    private boolean attendance;

    @Min(0)
    @Column
    private long learningStart;

    @Min(0)
    @Column
    private long learningStop;

    @Min(0)
    @Column
    private long totalLearningTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearningTimeGrade learningTimeGrade;

    @Description("날짜 유닉스타임 표기")
    @Column(nullable = false)
    private long baseDate;

    @Column(nullable = false)
    long memberId;

    public EducationHistory(boolean attendance, long learningStart, long learningStop, long totalLearningTime, LearningTimeGrade learningTimeGrade, long baseDate, long memberId) {
        this.attendance = attendance;
        this.learningStart = learningStart;
        this.learningStop = learningStop;
        this.totalLearningTime = totalLearningTime;
        this.learningTimeGrade = learningTimeGrade;
        this.baseDate = baseDate;
        this.memberId = memberId;
    }

    public long getTotalLeaningTimeMin() {
        return TimeUtils.EpochMilliToMinutes(this.totalLearningTime);
    }

    public int getWeekOfMonth() {
        return TimeUtils.weekOfMonth(this.getCreatedAt());
    }
}
