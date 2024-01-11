package vlrtstat.gg.duo.constant;

import org.springframework.core.convert.converter.Converter;

public class DuoMatchFilterConverter implements Converter<String, DuoMatchFilter> {
    @Override
    public DuoMatchFilter convert(String duoMatchFilter) {
        return DuoMatchFilter.fromText(duoMatchFilter);
    }
}
