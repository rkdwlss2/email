package com.example.email.Service;

import com.example.email.dto.MemberDto;
import com.example.email.entity.Member;

public interface MemberService {
    Member save(MemberDto memberDto);
}
