package june.module5.homework.controller;

import jakarta.servlet.http.HttpServletResponse;
import june.module5.homework.dto.AuthResponse;
import june.module5.homework.dto.LoginRequest;
import june.module5.homework.dto.SignupRequest;
import june.module5.homework.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request,
            HttpServletResponse response
    ) {

        return authService.login(
                request,
                response
        );
    }

    @PostMapping("/logout")
    public String logout(
            @CookieValue("refreshToken")
            String refreshToken,

            HttpServletResponse response
    ) {

        return authService.logout(
                refreshToken,
                response
        );
    }

    @PostMapping("/signup")
    public String signup(
            @RequestBody SignupRequest request
    ) {

        return authService.signup(request);
    }
}
