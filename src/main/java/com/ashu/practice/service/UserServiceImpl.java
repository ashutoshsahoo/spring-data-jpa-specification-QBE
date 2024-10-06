package com.ashu.practice.service;

import com.ashu.practice.model.Address;
import com.ashu.practice.model.User;
import com.ashu.practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        if (user.getRegTime() == null) {
            user.setRegTime(ZonedDateTime.now(ZoneOffset.UTC));
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User get(Long id) {
        log.info("get request for id:{}", id);
        User user = new User();
        user.setId(id);
        Example<User> example = Example.of(user);
        Optional<User> isUserPresent = userRepository.findOne(example);
        if (isUserPresent.isPresent()) {
            return isUserPresent.get();
        }
        log.info("User not found, throw exception.");
        throw new UserNotFoundException(id);
    }

    @Override
    public User getById(Long id) {
        log.info("getById request for id:{}", id);
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Page<User> search(String name, String addr1, String city, Integer page, Integer size) {
        log.info("search for User :name = {},addr1 = {},city = {}", name, addr1, city);
        User user = new User();
        user.setName(name);
        Address address = new Address();
        address.setAddr1(addr1);
        address.setCity(city);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        user.setAddresses(addresses);
        Example<User> example = Example.of(user);
        Page<User> users = userRepository.findAll(example, PageRequest.of(page, size));
        return users;
    }
}
