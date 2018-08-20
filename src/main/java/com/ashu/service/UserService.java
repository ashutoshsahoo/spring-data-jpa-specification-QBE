package com.ashu.service;

import org.springframework.data.domain.Page;

import com.ashu.model.User;

public interface UserService {

    User create(User user);

    User get(Long id);

    User getById(Long id);

    Page<User> search(String name, String addr1, String city, Integer page, Integer size);
}
