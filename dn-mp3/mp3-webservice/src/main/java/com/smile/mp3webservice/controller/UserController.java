package com.smile.mp3webservice.controller;

import com.smile.mp3dao.dto.UserDTO;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.UserService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

//    @GetMapping(value={"/lala"})
//    public ResponseEntity<List<UserDTO>> listAllUsers2() {
//        List<UserDTO> users = userService.getUsers2();
//        return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
//    }

    @GetMapping(value={"/update/{id}"})
    public ResponseEntity<UserDTO> myUserDTO(@PathVariable int id) {
        UserDTO user = userService.getUserDTO(id);
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @PutMapping(value={"/update/{id}"})
    public ResponseEntity<?> myUser(@PathVariable int id, @RequestBody User myuser) {
        myuser.setPassword(userService.getUser(id).getPassword());
            userService.updateUser(myuser);
            return ResponseEntity.ok(myuser);
    }

    @PostMapping(value={"/register"})
    public ResponseEntity<?> register(@RequestBody User myuser ) {
        if(userRepository.countByUsernameOrEmail(myuser.getUsername(),myuser.getEmail())>0) {
            HashMap<String, String> messeages = new HashMap<>();
            if (userRepository.countByUsername(myuser.getUsername()) > 0) {
                messeages.put("username","Username is existing");
            }
            if (userRepository.countByEmail(myuser.getEmail()) > 0) {
                messeages.put("email","Email is existing");
            }
            return new ResponseEntity<HashMap>(messeages, HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(myuser);
        return ResponseEntity.ok(myuser);
    }

//    @GetMapping(value = "/getUser/{id}")
//    public ResponseEntity<UserDTO> getUserId(@PathVariable int id){
//        Usr
//    }
}
