package me.hyeon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.hyeon.springbootdeveloper.domain.User;
import me.hyeon.springbootdeveloper.dto.AddUserRequest;
import me.hyeon.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    // 토큰 API 구현하기 메서드 추가
    public User findById(Long userID){
        return userRepository.findById(userID)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}