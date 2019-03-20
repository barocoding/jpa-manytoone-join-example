package com.example.jpa.repo;

import com.example.jpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {

}
