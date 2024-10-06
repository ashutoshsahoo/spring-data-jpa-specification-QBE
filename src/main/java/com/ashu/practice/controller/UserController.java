package com.ashu.practice.controller;

import com.ashu.practice.model.User;
import com.ashu.practice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);

    }

    @GetMapping(path = "/{id}")
    public User get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }

    @GetMapping(path = "/getById/{id}")
    public User getById(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/search")
    public Page<User> search(@RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "addr1", required = false) String addr1,
                             @RequestParam(name = "city", required = false) String city,
                             @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        return userService.search(name, addr1, city, page, size);
    }
}
