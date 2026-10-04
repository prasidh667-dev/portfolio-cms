package com.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name="testimonials")
public class Testimonial {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  private String role;
  private String company;
  private String quote;
  private String image;
  private int displayOrder;
  public Long getId(){return id;}
  public String getName(){return name;}
  public void setName(String v){name=v;}
  public String getRole(){return role;}
  public void setRole(String v){role=v;}
  public String getCompany(){return company;}
  public void setCompany(String v){company=v;}
  public String getQuote(){return quote;}
  public void setQuote(String v){quote=v;}
  public String getImage(){return image;}
  public void setImage(String v){image=v;}
  public int getDisplayOrder(){return displayOrder;}
  public void setDisplayOrder(int v){displayOrder=v;}
}