package org.weather.fashion.backend.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.weather.fashion.backend.entity.Member;
import org.weather.fashion.backend.repository.MemberRepository;
import org.weather.fashion.backend.service.JwtService;
import org.weather.fashion.backend.service.JwtServiceImpl;

import java.util.Map;


@RestController
public class AccountController {
  @Autowired
  MemberRepository memberRepository;

  @PostMapping("/api/account/login") // api를 만듬
  public ResponseEntity login(@RequestBody Map<String, String> params,
                              HttpServletResponse res) {
    Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));

    if (member != null) {
      JwtService jwtService = new JwtServiceImpl();
      int id = member.getId();
      String token = jwtService.getToken("id",id); // id값을 토큰화
      //return member.getId();

      Cookie cookie = new Cookie("token", token); // 토큰을 쿠키에 넣고
      cookie.setHttpOnly(true);
      cookie.setPath("/");

      res.addCookie(cookie);
      //return ResponseEntity.ok().build(); // 응답 값을준다
      return new ResponseEntity<>(id, HttpStatus.OK);
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

}
