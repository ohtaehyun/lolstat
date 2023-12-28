package vlrtstat.gg.global.email;

import com.amazonaws.services.simpleemail.model.*;

import java.util.List;

public class EmailSendDto {
    private static final String FROM_EMAIL = "othdev95@gmail.com";
    private final List<String> to;
    private final String subject;
    private final String content;

    public EmailSendDto(List<String> to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }
    public SendEmailRequest toSendRequestDto() {
        final Destination destination = new Destination()
                .withToAddresses(this.to);

        final Message message = new Message()
                .withSubject(createContent(this.subject))
                .withBody(new Body()
                        .withHtml(createContent(this.content)));

        return new SendEmailRequest()
                .withSource(FROM_EMAIL)
                .withDestination(destination)
                .withMessage(message);
    }

    private Content createContent(final String text) {
        return new Content()
                .withCharset("UTF-8")
                .withData(text);
    }
}
