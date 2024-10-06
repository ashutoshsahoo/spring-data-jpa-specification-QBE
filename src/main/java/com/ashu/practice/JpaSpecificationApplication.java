package com.ashu.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;
import java.util.TimeZone;

/**
 * Spring boot entry point.
 *
 * @author ashutosh
 */
@SpringBootApplication
public class JpaSpecificationApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
        SpringApplication.run(JpaSpecificationApplication.class, args);
    }

}
