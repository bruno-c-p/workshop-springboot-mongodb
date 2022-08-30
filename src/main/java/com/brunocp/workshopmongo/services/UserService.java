package com.brunocp.workshopmongo.services;

import com.brunocp.workshopmongo.domain.User;
import com.brunocp.workshopmongo.dto.UserDto;
import com.brunocp.workshopmongo.repository.UserRepository;
import com.brunocp.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {

        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDto(UserDto dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
