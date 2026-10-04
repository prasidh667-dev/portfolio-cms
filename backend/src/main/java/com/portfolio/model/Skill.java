package com.portfolio.model;
import jakarta.persistence.*;
@Entity @Table(name="skills")
public class Skill { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @Column(nullable=false) String name; int level; public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public int getLevel(){return level;} public void setLevel(int v){level=v;} }
