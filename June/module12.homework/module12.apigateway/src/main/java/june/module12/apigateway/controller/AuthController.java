package june.module12.apigateway.controller;

import june.module12.apigateway.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @GetMapping("/token")
    public String token() {
        return jwtUtil.generateToken("irfan", List.of("ADMIN", "USER"));
    }
}
