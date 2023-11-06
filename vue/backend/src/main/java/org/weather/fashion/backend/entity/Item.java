package org.weather.fashion.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

// 여기서는 table과 매핑이 되게 작업
@Getter
@Entity
@Table(name = "items")
public class Item {
  @Id // ptimary키
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가값 이다
  private int id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 100)
  private String imgPath;

  @Column
  private int price;

  @Column
  private String discountPer;


}
