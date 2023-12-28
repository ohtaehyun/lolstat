package vlrtstat.gg.global.email;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailSender {
    private final AmazonSimpleEmailService amazonSimpleEmailService;
    private Slack slack;

    @Value("${slack.url}")
    private String webhookUrl;

    public EmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
        this.slack = Slack.getInstance();
    }

    public void sendEmail(EmailSendDto emailSendDto) {
        SendEmailResult sendEmailResult = amazonSimpleEmailService.sendEmail(emailSendDto.toSendRequestDto());
        int resultCode = sendEmailResult.getSdkHttpMetadata().getHttpStatusCode();
        if (resultCode != 200) {
            Payload payload = Payload.builder().text("이메일 전송 실패\n" + "상태코드: " + resultCode).build();
            try {
                slack.send(webhookUrl, payload);
            } catch (IOException e) {
                System.out.println("sendEmail slack sending error = " + e);
            }
        }
    }
}
