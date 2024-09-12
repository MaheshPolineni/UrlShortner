package com.example.UrlShortner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Entity
@Table(name="url")
@Data
public class UrlEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column
    String shortenUrl;
    @Column
    String actualUrl;
}
