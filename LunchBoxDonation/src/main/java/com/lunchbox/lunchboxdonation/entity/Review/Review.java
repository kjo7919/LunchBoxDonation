package com.lunchbox.lunchboxdonation.entity.Review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String reviewContent;

//    도시락 연관 관계
//    멤버 연관 관계
}
