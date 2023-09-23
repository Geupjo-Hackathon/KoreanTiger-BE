package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.util.TimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class Lecture extends BaseEntity {

    @Description("강의 이름")
    @Column
    private String name;

    @Description("강의 코드")
    @Column
    private String code;

    @Description("강의 진행률")
    @Min(0)
    @Max(100)
    @Column
    private int progress;

    @Column
    private long memberId;

    public Lecture(String name, String code, int progress, long memberId) {
        this.name = name;
        this.code = code;
        this.progress = progress;
        this.memberId = memberId;
    }

    public boolean isComplete() {
        return this.progress == 100;
    }

    public int getWeekOfMonth() {
        return TimeUtils.weekOfMonth(this.getCreatedAt());
    }
}
