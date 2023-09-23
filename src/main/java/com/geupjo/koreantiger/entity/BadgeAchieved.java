package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.Badge;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(schema = "geupjo")
@Entity
public class BadgeAchieved extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Badge badge;

    @Column(nullable = false)
    private long memberId;
}
