package vlrtstat.gg.global.feign;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.rmi.ServerException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private Slack slack;

    @Value("${slack.url}")
    private String webhookUrl;

    public FeignErrorDecoder() {
        slack = Slack.getInstance();
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 404:
                try {
                    Payload payload = Payload.builder().text(
                            "methodKey: " + methodKey + "\n" +
                            "reason: " + response.reason() + "\n" +
                            "url: " + response.request().url()
                    ).build();
                    slack.send(webhookUrl, payload);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return new ServerException(response.reason());
            case 429:
                try {
                    Payload payload = Payload.builder().text(
                            "methodKey: " + methodKey + "\n" +
                                    "reason: API 호출 한도 초과\n" +
                                    "url: " + response.request().url()
                    ).build();
                    slack.send(webhookUrl, payload);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return new Exception(response.reason());
        }
    }
}