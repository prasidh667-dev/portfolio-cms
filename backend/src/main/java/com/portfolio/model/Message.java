package com.portfolio.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email
    @Size(max = 180)
    @Column(nullable = false)
    private String email;

    @Size(max = 200)
    private String subject;

    @NotBlank
    @Size(max = 5000)
    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String v) {
        email = v;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String v) {
        subject = v;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String v) {
        message = v;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}