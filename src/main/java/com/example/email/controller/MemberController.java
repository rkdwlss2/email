package com.example.email.controller;

import com.example.email.Service.MemberService;
import com.example.email.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 접근
    @GetMapping("/register")
    public String getRegisterForm(MemberDto memberDto) {
        return "register";
    }

    // 회원가입 진행
    @PostMapping("/register")
    public String register(MemberDto memberDto) {
        log.info("member register : {}", memberDto.getPassword());
        memberService.save(memberDto);
        return "redirect:/login";
    }

    // 로그인 페이지 접근
    @GetMapping("/login")
    public String getLoginForm(MemberDto memberDto) {
        return "login";
    }

    // 메인 페이지 접근
    @GetMapping("/main")
    public String main(MemberDto memberDto, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "main";
    }

    // 로그아웃 진행
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }

    // 유저 페이지 접근
    @GetMapping("/user")
    public String user(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "user";
    }

    // 관리자 페이지 접근
    @GetMapping("/admin")
    public String admin(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "admin";
    }
}
