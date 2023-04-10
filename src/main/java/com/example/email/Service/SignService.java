//package com.example.email.Service;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class SignService {
//
//    private final JwtTokenProvider jwtTokenProvider;
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Transactional
//    public MemberRegisterResponseDto registerMember(MemberRegisterRequestDto requestDto) {
//        validateDuplicated(requestDto.getEmail());
//        Member user = memberRepository.save(
//                Member.builder()
//                        .email(requestDto.getEmail())
//                        .password(passwordEncoder.encode(requestDto.getPassword()))
//                        .build());
//        return new MemberRegisterResponseDto(user.getId(), user.getEmail());
//    }
//
//    /**
//     * Unique한 값을 가져야하나, 중복된 값을 가질 경우를 검증
//     * @param email
//     */
//    public void validateDuplicated(String email) {
//        if (memberRepository.findByEmail(email).isPresent())
//            throw new MemberEmailAlreadyExistsException();
//    }
//
//    public MemberLoginResponseDto loginMember(MemberLoginRequestDto requestDto) {
//        Member member = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow(LoginFailureException::new);
//        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword()))
//            throw new LoginFailureException();
//        return new MemberLoginResponseDto(member.getId(), jwtTokenProvider.createToken(requestDto.getEmail()));
//
//    }
//}
