package vlrtstat.gg.user.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vlrtstat.gg.jwt.JwtProvider;
import vlrtstat.gg.user.dto.*;
import vlrtstat.gg.user.service.UserService;

@RestController
@Tag(name = "User", description = "사용자 API")
public class UserController {
    private final UserService userService;

    private  final JwtProvider jwtProvider;

    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("user")
    public void CreateUser(@RequestBody @Valid CreateUesrRequest createUesrRequest) {
        userService.createUser(createUesrRequest.getEmail(), createUesrRequest.getPassword(), createUesrRequest.getPasswordCheck());
    }

    @PutMapping("user/verify")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public void verifyEmail(@Valid @RequestBody UserVerifyRequest userVerifyRequest, @RequestHeader(name = "Authorization") String authorization) {
        String accessToken = authorization.split(" ")[1];
        String verificationCode = userVerifyRequest.getVerificationCode();
        userService.verifyUser(accessToken, verificationCode);
    }

    @PostMapping("user/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return userService.login(email, password);
    }

    @PostMapping("user/login/test")
    public LoginResponse testLogin() {
        return userService.testLogin();
    }

    @PostMapping("user/auth/test")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public void test() {}

    @PostMapping("user/refresh")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER, description = "Refresh Token")
    public RefreshTokenResponse refreshAccessToken(@RequestHeader("Authorization") String authorization) {
        String refreshToken = authorization.split(" ")[1];
        return userService.refreshAccessToken(refreshToken);
    }

    @DeleteMapping("user")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public void deleteUser(@RequestHeader("Authorization") String authorization) {
        String accessToken = jwtProvider.extractToken(authorization);
        userService.withdrawl(accessToken);
    }
}
