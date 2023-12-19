package vlrtstat.gg.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.user.dto.CreateUesrRequest;
import vlrtstat.gg.user.service.UserService;

@RestController()
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public void CreateUser(@RequestBody CreateUesrRequest createUesrRequest) {
        userService.createUser(createUesrRequest.getEmail(), createUesrRequest.getPassword(), createUesrRequest.getPasswordCheck());
    }

    @PostMapping("user/verify")
    public void SendVerifyEmail(String email) {

    }

    @PutMapping("user/verify")
    public void verifyEmail(String verificationCode) {

    }
}
