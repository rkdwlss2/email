package com.example.email.Service;

import com.example.email.Repository.MemberRepository;
import com.example.email.dto.MemberDto;
import com.example.email.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional
    public Member save(MemberDto memberDto){
        return memberRepository.save(Member.builder()
                .username(memberDto.getUsername())
                        .password(passwordEncoder.encode(memberDto.getPassword()))
                        .roleType(memberDto.getRoleType())
                .build());
    }
}
