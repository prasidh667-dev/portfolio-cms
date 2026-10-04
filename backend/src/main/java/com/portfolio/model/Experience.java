package com.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name="experience")
public class Experience {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String company;
  private String role;
  private String location;
  private String startDate;
  private String endDate;
  @Column(columnDefinition="TEXT") private String description;
  private int displayOrder;
  public Long getId(){return id;}
  public String getCompany(){return company;}
  public void setCompany(String v){company=v;}
  public String getRole(){return role;}
  public void setRole(String v){role=v;}
  public String getLocation(){return location;}
  public void setLocation(String v){location=v;}
  public String getStartDate(){return startDate;}
  public void setStartDate(String v){startDate=v;}
  public String getEndDate(){return endDate;}
  public void setEndDate(String v){endDate=v;}
  public String getDescription(){return description;}
  public void setDescription(String v){description=v;}
  public int getDisplayOrder(){return displayOrder;}
  public void setDisplayOrder(int v){displayOrder=v;}
}