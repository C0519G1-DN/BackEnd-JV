package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Integer> {
    List<Singer> findAllByDelectedIsFalse();
    List<Singer> findAllByName(String searchName);
    List<Singer> findAllByNameContaining(String searchName);
    Singer findByName(String name);

}
