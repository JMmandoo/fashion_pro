package org.weather.fashion.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

// 여기서는 table과 매핑이 되게 작업
@Getter
@Entity
@Table(name = "members")
public class Member {
  @Id // ptimary키
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가값이다
  private int id;

  @Column(length = 50, nullable = false, unique = true)
  private String email;

  @Column(length = 100, nullable = false)
  private String password;

}
