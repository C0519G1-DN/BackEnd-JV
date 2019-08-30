package com.smile.mp3service.service;

import com.smile.mp3dao.dto.UserDTO;
import com.smile.mp3dao.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUsers();
    List<UserDTO> getUsers2();

    void saveUser(User theUser);

    User getUser(int theId);

    void deleteUser(int theId);
}
