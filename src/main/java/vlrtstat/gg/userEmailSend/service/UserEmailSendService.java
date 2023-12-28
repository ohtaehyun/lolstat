package vlrtstat.gg.userEmailSend.service;

import vlrtstat.gg.user.domain.User;

public interface UserEmailSendService {
    void sendAuthenticateEmail(User user);
}
