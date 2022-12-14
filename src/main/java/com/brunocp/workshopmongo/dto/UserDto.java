package com.brunocp.workshopmongo.dto;

import com.brunocp.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 500441489926525567L;

    private String id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getEmail();
        this.email = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
