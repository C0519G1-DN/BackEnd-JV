package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.UserDTO;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public List<UserDTO> getUsers2() {
        List<User> a= userRepository.findAll();
        List<UserDTO> b = new ArrayList<>();
        for (User c:a
        ) {b.add(new UserDTO(c));

        }
        return b;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User theUser)
    {
        String hash = BCrypt.hashpw(theUser.getPassword(), BCrypt.gensalt(12));
        theUser.setPassword(hash);
        userRepository.save(theUser);
    }

    @Override
    public void updateUser(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public UserDTO getUserDTO(int theId) {
        User d= userRepository.findById(theId).orElse(null);
        UserDTO e = new UserDTO(d);
        return e;
    }

    @Override
    public User getUser(int theId) {
        return userRepository.findById(theId).orElse(null);
    }

    @Override
    public void deleteUser(int theId) {

    }
}
