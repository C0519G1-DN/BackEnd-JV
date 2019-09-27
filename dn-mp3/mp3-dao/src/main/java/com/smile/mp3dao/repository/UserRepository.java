package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {
    Long countByUsernameOrEmail(String username, String email);
    Long countByUsername(String username);
    Long countByEmail(String email);
    User findByUsername(String username);
    User findAllByDelectedIsFalseAndId(int id);

}
