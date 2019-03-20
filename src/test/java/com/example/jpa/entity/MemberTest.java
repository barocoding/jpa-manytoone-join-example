package com.example.jpa.entity;

import com.example.jpa.dto.MemberMapping;
import com.example.jpa.repo.MemberRepo;
import com.example.jpa.repo.TeamRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {
    @Autowired
    MemberRepo memberRepo;

    @Autowired
    TeamRepo teamRepo;

    @Before
    @Transactional
    public void setup() {
        Team team = new Team();
        team.setName("team-1");
        team = teamRepo.save(team);

        Team team2 = new Team();
        team2.setName("team-2");
        team2 = teamRepo.save(team2);

        Member member = new Member();
        member.setName("member-1");
        member.setTeam(team);
        memberRepo.save(member);

        Member member1 = new Member();
        member1.setName("member-2");
        member1.setTeam(team2);
        memberRepo.save(member1);
    }

    @Test
    public void joinTest() {
        System.out.println("-result entity-------------");
        List<Member> all = memberRepo.findAll();
        for (Member member1 : all) {
            System.out.println(member1.getTeam().getName());
        }
        System.out.println("--------------------");

        System.out.println("-result dto---------");
        List<MemberMapping> memberAll = memberRepo.findAllBy();
        for (MemberMapping member1 : memberAll) {
            System.out.println(member1.getTeam().getName());
        }
        System.out.println("--------------------");
    }
}