package com.smile.mp3webservice.controller;

import com.smile.mp3dao.constant.AppConstant;
import com.smile.mp3dao.dto.UserDTO;
import com.smile.mp3dao.entity.Playlist;
import com.smile.mp3dao.entity.UpdatePassword;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.UserService;

import com.smile.mp3webservice.security.JwtResponse;
import com.smile.mp3webservice.security.JwtTokenUtil;
import com.smile.mp3webservice.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @Autowired
    public JavaMailSender emailSender;


    static String getAlphaNumericString(int n) {

        // lower limit for LowerCase Letters
        int lowerLimit = 97;

        // lower limit for LowerCase Letters
        int upperLimit = 122;

        Random random = new Random();

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {

            // take a random value between 97 and 122
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));

            // append a character at the end of bs
            r.append((char) nextRandomChar);
        }

        // return the resultant string
        return r.toString();
    }


    @GetMapping(value = {"/update/{id}"})
    public ResponseEntity<UserDTO> myUserDTO(@PathVariable int id) {
        UserDTO user = userService.getUserDTO(id);
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @PutMapping(value = {"/update/{id}"})
    public ResponseEntity<?> myUser(@PathVariable int id, @RequestBody User myuser) {
        myuser.setPassword(userService.getUser(id).getPassword());
        userService.updateUser(myuser);
        return ResponseEntity.ok(myuser);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<?> register(@RequestBody User myuser) {
        if (userRepository.countByUsernameOrEmail(myuser.getUsername(), myuser.getEmail()) > 0) {
            HashMap<String, String> messeages = new HashMap<>();
            if (userRepository.countByUsername(myuser.getUsername()) > 0) {
                messeages.put("username", "Username is existing");
            }
            if (userRepository.countByEmail(myuser.getEmail()) > 0) {
                messeages.put("email", "Email is existing");
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
    @GetMapping(value = {"/admin"})
    public ResponseEntity<?> getforadmin() {
//         Object user= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
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

    @PutMapping({"/update-password/{id}"})
    public ResponseEntity<?> changePassword(@PathVariable("id") int id,
                                            @RequestBody UpdatePassword updatePassword) {
        User user = userService.getUser(id);
        if (user != null) {
            if (BCrypt.checkpw(updatePassword.getCurrentPassword(), user.getPassword())) {
                user.setPassword(updatePassword.getNewPassword());
                userService.updatePassword(user);
                return new ResponseEntity<>("{\"text\":\"Successful\"}", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("{\"text\":\"NotCompare\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"text\":\"NotFound\"}", HttpStatus.OK);

    }

    @PostMapping("/postEmail")
    public ResponseEntity<?> getUserByEmail(@RequestBody String email) throws MessagingException {
        String email123 = userService.getEmailUser(email);
        Playlist feedback = new Playlist();
        if (email123 != null) {
            String newPassword = this.getAlphaNumericString(10);
            System.out.println(newPassword);
            userService.resetPass(email123, newPassword);
            sendAttachmentEmail(newPassword, email123);

            return new ResponseEntity<Playlist>(feedback, HttpStatus.OK);
        } else {
            System.out.println("Error");
        }
        return new ResponseEntity<Playlist>(feedback, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @RequestMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail(String newPassword, String email) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
        //helper.setTo(userService.getEmailUser(emailSender));
        helper.setTo(email);
        helper.setSubject("Reset pass Delivery Smile");

        helper.setText("New Password :" + newPassword);

//        String path1 = "D:\\Quiz\\ahihi.txt";

        // Attachment 1
//        FileSystemResource file1 = new FileSystemResource(new File(path1));
//        helper.addAttachment("Txt file", file1);

        emailSender.send(message);

        return "Email Sent!";
    }

}
