package com.smile.mp3webservice.security;

import com.smile.mp3dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static javax.xml.bind.DatatypeConverter.parseString;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public int getIdByUsername(String username){
        com.smile.mp3dao.entity.User user= userRepository.findByUsername(username);
        return user.getId();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.smile.mp3dao.entity.User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("User not found");
        }
        String name = user.getUsername();
        String password=user.getPassword();
        Set<GrantedAuthority> grantedAuthoritySet=new HashSet<>();
        if("admin".equals(name)) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User( name , password, grantedAuthoritySet);
    }
}
