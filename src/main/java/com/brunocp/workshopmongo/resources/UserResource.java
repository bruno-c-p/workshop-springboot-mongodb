package com.brunocp.workshopmongo.resources;

import com.brunocp.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        User user = new User("1", "Maria Brown", "maria@gmail.com");
        User user2 = new User("2", "Alex Green", "maria@gmail.com");

        return ResponseEntity.ok().body(Arrays.asList(user, user2));
    }
}
