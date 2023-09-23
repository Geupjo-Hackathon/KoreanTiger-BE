package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class CodeBox extends BaseEntity {

    @Column
    private String name;

    @Column
    private String code;

    @Column(nullable = false)
    private long memberId;

    public CodeBox(String name, String code, long memberId) {
        this.name = name;
        this.code = code;
        this.memberId = memberId;
    }
}
