package com.portfolio.model;
import jakarta.persistence.*;
@Entity @Table(name="about")
public class About { @Id Long id=1L; String name; String headline; @Column(columnDefinition="TEXT") String bio; String email; String location; public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getHeadline(){return headline;} public void setHeadline(String v){headline=v;} public String getBio(){return bio;} public void setBio(String v){bio=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} }
