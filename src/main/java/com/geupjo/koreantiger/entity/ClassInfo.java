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
public class ClassInfo extends BaseEntity {
    @Column
    private String name;

    public ClassInfo(String name) {
        this.name = name;
    }
}
