package com.example.jpa.dto;

import com.example.jpa.entity.Team;

public interface MemberMapping {
    Long getId();
    String getName();
    Team getTeam();
}
