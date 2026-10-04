package com.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name="services")
public class Service {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String title;
  @Column(columnDefinition="TEXT") private String description;
  private String icon;
  private int displayOrder;
  public Long getId(){return id;}
  public String getTitle(){return title;}
  public void setTitle(String v){title=v;}
  public String getDescription(){return description;}
  public void setDescription(String v){description=v;}
  public String getIcon(){return icon;}
  public void setIcon(String v){icon=v;}
  public int getDisplayOrder(){return displayOrder;}
  public void setDisplayOrder(int v){displayOrder=v;}
}