package com.ashu.clr;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;

import com.ashu.model.Address;
import com.ashu.model.User;
import com.ashu.repository.UserRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
	Address address2 = new Address(null, "A-16", "sector-60", "noida", "INDIA", 201301);

	List<Address> addresses = new ArrayList<>();
	addresses.add(address1);
	addresses.add(address2);
	User user = new User(null, "Ashutosh", ZonedDateTime.now(ZoneOffset.UTC), addresses);

	userRepo.saveAndFlush(user);

	Address address3 = new Address(null, "addr1", "addr2", "city", "country", 102343);
	Address address4 = new Address(null, "HIG-21", "BJB Nagar", "BBSR", "INDIA", 751012);

	List<Address> addresses2 = new ArrayList<>();
	addresses2.add(address3);
	addresses2.add(address4);
	User user2 = new User(null, "Ashutosh Sahoo", ZonedDateTime.now(ZoneOffset.UTC), addresses2);

	userRepo.saveAndFlush(user2);
    }

}
