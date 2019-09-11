package com.smile.mp3webservice.controller;

import com.smile.mp3dao.dto.UserDTO;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.UserService;

import com.smile.mp3webservice.security.JwtResponse;
import com.smile.mp3webservice.security.JwtTokenUtil;
import com.smile.mp3webservice.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


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


//    @PostMapping("/register")
//    public ResponseEntity<?> createAccounts(@Valid @RequestBody User myuser, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
//        }
//        userService.saveUser(myuser);
//        return ResponseEntity.ok(myuser);
//    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value={"/admin"})
    public ResponseEntity<?> getforadmin() {
//         Object user= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody User user ) throws Exception {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
                );
                String jwtToken = jwtTokenUtil.generateToken(authentication);
                int id = userDetailsService.getIdByUsername(user.getUsername());
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                return new ResponseEntity<>(new JwtResponse(jwtToken, userDetails.getUsername(), id), HttpStatus.OK);
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
    }

}
