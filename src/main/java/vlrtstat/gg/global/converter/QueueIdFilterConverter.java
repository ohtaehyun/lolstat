package vlrtstat.gg.global.converter;

import org.springframework.core.convert.converter.Converter;
import vlrtstat.gg.global.filter.QueueIdFilter;

public class QueueIdFilterConverter implements Converter<String, QueueIdFilter> {
    @Override
    public QueueIdFilter convert(String source) {
        return QueueIdFilter.fromText(source.toUpperCase());
    }
}
