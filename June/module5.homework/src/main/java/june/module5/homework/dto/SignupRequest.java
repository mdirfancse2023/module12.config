package june.module5.homework.dto;

public record SignupRequest(
        String email,
        String password,
        String role
) {
}
