package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.Badge;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(schema = "geupjo")
@Entity
@NoArgsConstructor
public class BadgeAchieved extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Badge badge;

    @Column(nullable = false)
    private long memberId;

    public BadgeAchieved(Badge badge, long memberId) {
        this.badge = badge;
        this.memberId = memberId;
    }
}
