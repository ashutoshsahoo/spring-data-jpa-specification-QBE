package com.ashu;

import java.time.ZoneOffset;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot entry point.
 *
 * @author ashutosh
 *
 */
@SpringBootApplication
public class JpaSpecificationApplication {

    public static void main(String[] args) {
	SpringApplication.run(JpaSpecificationApplication.class, args);
    }

    @PostConstruct
    void started() {
	TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
    }
}
