package vlrtstat.gg.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vlrtstat.gg.user.dto.CreateUesrRequest;
import vlrtstat.gg.user.dto.LoginRequest;
import vlrtstat.gg.user.dto.LoginResponse;
import vlrtstat.gg.user.service.UserService;

@RestController
@Tag(name = "User", description = "사용자 API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public void CreateUser(@RequestBody @Valid CreateUesrRequest createUesrRequest) {
        userService.createUser(createUesrRequest.getEmail(), createUesrRequest.getPassword(), createUesrRequest.getPasswordCheck());
    }

    @PostMapping("user/verify")
    public void SendVerifyEmail(String email) {

    }

    @PutMapping("user/verify")
    public void verifyEmail(String verificationCode) {

    }

    @PostMapping("user/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return userService.login(email, password);
    }
}
