package com.example.jpa.repo;

import com.example.jpa.dto.MemberMapping;
import com.example.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {
    List<MemberMapping> findAllBy();
}
