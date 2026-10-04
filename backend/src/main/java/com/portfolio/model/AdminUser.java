package com.portfolio.model;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class AdminUser { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; @Column(unique=true,nullable=false) String username; @Column(nullable=false) String password; String role="ADMIN"; public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public String getRole(){return role;} }
