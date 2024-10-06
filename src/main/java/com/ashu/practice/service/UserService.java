package com.ashu.practice.service;

import com.ashu.practice.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User create(User user);

    User get(Long id);

    User getById(Long id);

    Page<User> search(String name, String addr1, String city, Integer page, Integer size);
}
