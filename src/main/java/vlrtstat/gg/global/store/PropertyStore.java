package vlrtstat.gg.global.store;

import org.springframework.context.ApplicationContext;

public class PropertyStore {
    public static String getProperty(String key) {
        ApplicationContext ac = ApplicationContextStore.getApplicationContext();
        return ac.getEnvironment().getProperty(key);
    }
}
