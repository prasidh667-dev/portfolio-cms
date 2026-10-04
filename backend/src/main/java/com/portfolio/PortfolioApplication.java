package com.portfolio;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

    private static final String DEFAULT_TIMEZONE = "UTC";

    public static void main(String[] args) {

        applyCanonicalTimeZone();

        SpringApplication.run(PortfolioApplication.class, args);
    }

    /**
     * On Windows the JVM reports CLDR ids such as "Asia/Calcutta", which PostgreSQL
     * rejects while processing the connection startup packet ("invalid value for
     * parameter TimeZone"). The pgjdbc TimeZone connection property does not override
     * that value, so the JVM default must be canonical before any DataSource is built.
     * Defaults to UTC; set APP_TIMEZONE (or -Dapp.timezone) for local time.
     */
    private static void applyCanonicalTimeZone() {

        String requested = System.getProperty("app.timezone");
        if (requested == null || requested.isBlank()) {
            requested = System.getenv("APP_TIMEZONE");
        }
        if (requested == null || requested.isBlank()) {
            requested = DEFAULT_TIMEZONE;
        }

        TimeZone zone = TimeZone.getTimeZone(requested);

        if ("GMT".equals(zone.getID()) && !"GMT".equals(requested)) {
            zone = TimeZone.getTimeZone(DEFAULT_TIMEZONE);
        }

        TimeZone.setDefault(zone);
    }
}