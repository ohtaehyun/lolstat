package vlrtstat.gg.match.constant;

import org.springframework.core.convert.converter.Converter;
import vlrtstat.gg.global.constant.QueueId;

public class QueueIdFilterConverter implements Converter<String, QueueIdFilter> {
    @Override
    public QueueIdFilter convert(String source) {
        return QueueIdFilter.fromText(source.toUpperCase());
    }
}
