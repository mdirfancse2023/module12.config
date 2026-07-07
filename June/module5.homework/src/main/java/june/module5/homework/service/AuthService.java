package june.module5.homework.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import june.module5.homework.dto.AuthResponse;
import june.module5.homework.dto.LoginRequest;
import june.module5.homework.dto.SignupRequest;
import june.module5.homework.entity.User;
import june.module5.homework.entity.UserSession;
import june.module5.homework.repository.UserRepository;
import june.module5.homework.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserSessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthResponse login(
            LoginRequest request,
            HttpServletResponse response
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String accessToken =
                jwtService.generateAccessToken(
                        request.email()
                );

        String refreshToken =
                jwtService.generateRefreshToken(
                        request.email()
                );

        UserSession session = new UserSession();

        session.setEmail(request.email());
        session.setRefreshToken(refreshToken);
        session.setLoginTime(LocalDateTime.now());
        session.setIsActive(true);

        sessionRepository.save(session);

        Cookie cookie =
                new Cookie("refreshToken", refreshToken);

        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);

        response.addCookie(cookie);

        return new AuthResponse(accessToken);
    }

    public String logout(
            String refreshToken,
            HttpServletResponse response
    ) {

        Optional<UserSession> optionalSession =
                sessionRepository.findByRefreshToken(refreshToken);

        if (optionalSession.isPresent()) {

            UserSession session =
                    optionalSession.get();

            session.setIsActive(false);

            sessionRepository.save(session);
        }

        Cookie cookie =
                new Cookie("refreshToken", null);

        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "Logged out successfully";
    }

    public String signup(SignupRequest request) {

        Optional<User> existingUser =
                userRepository.findByEmail(
                        request.email()
                );

        if (existingUser.isPresent()) {

            throw new RuntimeException(
                    "User already exists"
            );
        }

        User user = new User();

        user.setEmail(request.email());

        user.setPassword(
                passwordEncoder.encode(
                        request.password()
                )
        );

        user.setRole(request.role());

        userRepository.save(user);

        return "User registered successfully";
    }
}
