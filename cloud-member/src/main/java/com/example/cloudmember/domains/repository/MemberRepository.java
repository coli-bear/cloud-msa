package com.example.cloudmember.domains.repository;

import com.example.cloudmember.domains.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
