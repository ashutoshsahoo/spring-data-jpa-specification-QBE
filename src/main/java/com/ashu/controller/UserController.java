package com.ashu.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.model.User;
import com.ashu.service.UserService;

@RestController
@RequestMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
	super();
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
