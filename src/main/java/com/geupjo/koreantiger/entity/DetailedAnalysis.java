package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class DetailedAnalysis extends BaseEntity {
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int grammar;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int assignment;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int algorithm;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int recursive;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int string;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int total;

    @Column(nullable = false)
    private long memberId;

    public DetailedAnalysis(int grammar, int assignment, int algorithm, int recursive, int string, int total, long memberId) {
        this.grammar = grammar;
        this.assignment = assignment;
        this.algorithm = algorithm;
        this.recursive = recursive;
        this.string = string;
        this.total = total;
        this.memberId = memberId;
    }
}
