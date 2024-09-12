package com.example.UrlShortner.repository;

import com.example.UrlShortner.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UrlRepository extends JpaRepository<UrlEntity,Long> {
}
