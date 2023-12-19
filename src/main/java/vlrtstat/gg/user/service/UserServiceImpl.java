package vlrtstat.gg.user.service;


import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.repository.UserRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void createUser(String email, String password, String passwordCheck) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        } else if (!password.equals(passwordCheck)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        String salt = this.getSalt();

        User user = new User();
        user.setEmail(email);
        user.setPassword(this.encrypt(password, salt));
        user.setVerified(false);
        user.setSalt(salt);
        user.setCreatedAt(new Date());
        userRepository.save(user);
    }
}
