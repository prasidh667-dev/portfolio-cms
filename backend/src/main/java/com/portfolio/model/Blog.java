package com.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name="blogs")
public class Blog {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String title;
  private String slug;
  private String excerpt;
  @Column(columnDefinition="TEXT") private String content;
  private String image;
  private boolean published;
  private int displayOrder;
  public Long getId(){return id;}
  public String getTitle(){return title;}
  public void setTitle(String v){title=v;}
  public String getSlug(){return slug;}
  public void setSlug(String v){slug=v;}
  public String getExcerpt(){return excerpt;}
  public void setExcerpt(String v){excerpt=v;}
  public String getContent(){return content;}
  public void setContent(String v){content=v;}
  public String getImage(){return image;}
  public void setImage(String v){image=v;}
  public boolean getPublished(){return published;}
  public void setPublished(boolean v){published=v;}
  public int getDisplayOrder(){return displayOrder;}
  public void setDisplayOrder(int v){displayOrder=v;}
}