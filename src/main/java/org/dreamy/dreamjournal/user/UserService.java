package org.dreamy.dreamjournal.user;

import lombok.RequiredArgsConstructor;
import org.dreamy.dreamjournal.user.dto.LoginRequest;
import org.dreamy.dreamjournal.user.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User register(RegisterRequest request) {
        if (userRepository.existsByEmailAndOauthProvider(request.getEmail(), request.getPassword())) {
            throw new RuntimeException("Email already registered");
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setNickname(request.getNickname());
        newUser.setOauthProvider("local");
        return userRepository.save(newUser);
    }

    public User login(LoginRequest request) {
        User user = userRepository.findByEmailAndOauthProvider(request.getEmail(), passwordEncoder.encode(request.getPassword()))
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

}
