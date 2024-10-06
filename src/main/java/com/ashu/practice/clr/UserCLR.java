package com.ashu.practice.clr;

import com.ashu.practice.model.Address;
import com.ashu.practice.model.User;
import com.ashu.practice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

//@Component
@Slf4j
@Data
public class UserCLR implements CommandLineRunner {

    private final UserRepository userRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("user clr called");
        Address address1 = new Address(null, "addr1", "addr2", "city", "country", 102340);
        Address address2 = new Address(null, "A-167", "sector-1089", "noida", "INDIA", 201301);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        User user = new User(null, "Ashutosh", ZonedDateTime.now(ZoneOffset.UTC), addresses);

        userRepo.saveAndFlush(user);

        Address address3 = new Address(null, "addr1", "addr2", "city", "country", 102343);
        Address address4 = new Address(null, "HIG-210", "BJB Nagar", "BBSR", "INDIA", 751012);

        List<Address> addresses2 = new ArrayList<>();
        addresses2.add(address3);
        addresses2.add(address4);
        User user2 = new User(null, "Ashutosh Sahoo", ZonedDateTime.now(ZoneOffset.UTC), addresses2);

        userRepo.saveAndFlush(user2);
    }

}
