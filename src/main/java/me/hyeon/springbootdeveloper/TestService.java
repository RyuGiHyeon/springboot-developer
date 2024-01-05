package me.hyeon.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;  // 빈 주입

    protected List<Member> getAllMembers(){
        return memberRepository.findAll();  // 맴버 목록 얻기
    }

}
