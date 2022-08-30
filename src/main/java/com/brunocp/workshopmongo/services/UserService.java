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

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {

        Optional<User> newUser = repository.findById(user.getId());

        updateData(newUser, user);
        
        return repository.save(newUser.get());
    }

    private void updateData(Optional<User> newUser, User user) {
        newUser.get().setName(user.getName());
        newUser.get().setEmail(user.getEmail());
    }
}
