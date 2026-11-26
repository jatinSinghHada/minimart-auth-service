package com.minimart.auth_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long userId;

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @NotBlank
    @Column(name="email")
    private String email;

    @NotBlank
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="role")
    private String role;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}
