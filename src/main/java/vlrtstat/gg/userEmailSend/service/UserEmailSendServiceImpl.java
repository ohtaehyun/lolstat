package vlrtstat.gg.userEmailSend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vlrtstat.gg.global.email.EmailSendDto;
import vlrtstat.gg.global.email.EmailSender;
import vlrtstat.gg.user.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserEmailSendServiceImpl implements UserEmailSendService{
    @Autowired
    private EmailSender emailSender;

    private static final Random random = new Random();

    @Override
    public void sendAuthenticateEmail(User user) {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        String code = sb.toString();

        List<String> to = new ArrayList<>();
        to.add(user.getEmail());

        String subject = "lolstat 회원가입 인증코드입니다.";
        String content = "회원인증 코드는 " + code + " 입니다.";

        EmailSendDto emailSendDto = new EmailSendDto(to, subject, content);
        emailSender.sendEmail(emailSendDto);
    }
}
