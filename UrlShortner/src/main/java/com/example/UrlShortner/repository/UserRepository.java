package com.example.UrlShortner.repository;

import com.example.UrlShortner.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    @Query(value = "select * from url_shortner.user_entity where email=?1",nativeQuery = true)
    UserEntity findByEmail(String email);
}
