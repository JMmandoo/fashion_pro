package org.weather.fashion.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.weather.fashion.backend.entity.Member;
import org.weather.fashion.backend.repository.MemberRepository;

import java.util.Map;


@RestController
public class AccountController {
  @Autowired
  MemberRepository memberRepository;

  @PostMapping("api/account/login") // api를 만듬
  public int login(@RequestBody Map<String, String> params) {
    Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));

    if (member != null) {
      return member.getId();
    }
    return 0;
  }

}
