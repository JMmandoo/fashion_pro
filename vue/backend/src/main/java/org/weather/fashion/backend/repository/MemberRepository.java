package org.weather.fashion.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.weather.fashion.backend.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
  Member findByEmailAndPassword(String email, String password);
}
