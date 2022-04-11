package com.intrum.framework.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String FILE_NAME = "properties/intrum/default.properties";

    private static final String DEFAULT_INTRUM_LATVIA_URL = "default.intrum.latvia.url";

    private static final String BROWSER_NAME = "default.browser.name";

    private final Properties properties;

    private static Config CONFIG;

    private Config() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);

        properties = new Properties();

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property not found: " + FILE_NAME);
        }
    }

    public static Config getInstance() {
        if (CONFIG == null) {
            synchronized (Config.class) {
                try {
                    CONFIG = new Config();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return CONFIG;
    }

    public String getDefaultIntrumLatviaUrl() {
        return properties.getProperty(DEFAULT_INTRUM_LATVIA_URL);
    }

    public String getBrowserName() {
        return properties.getProperty(BROWSER_NAME);
    }
}