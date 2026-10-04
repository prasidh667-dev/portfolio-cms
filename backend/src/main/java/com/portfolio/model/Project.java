package com.portfolio.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="projects")
public class Project {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false) private String title;
  @Column(columnDefinition="TEXT") private String description;
  private String image;
  private String githubUrl;
  private String liveUrl;
  private boolean featured;
  private int displayOrder;
  @ElementCollection(fetch=FetchType.EAGER) private List<String> technologies = new ArrayList<>();
  public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
  public String getDescription(){return description;} public void setDescription(String v){description=v;}
  public String getImage(){return image;} public void setImage(String v){image=v;}
  public String getGithubUrl(){return githubUrl;} public void setGithubUrl(String v){githubUrl=v;}
  public String getLiveUrl(){return liveUrl;} public void setLiveUrl(String v){liveUrl=v;}
  public boolean isFeatured(){return featured;} public void setFeatured(boolean v){featured=v;}
  public int getDisplayOrder(){return displayOrder;} public void setDisplayOrder(int v){displayOrder=v;}
  public List<String> getTechnologies(){return technologies;} public void setTechnologies(List<String> v){technologies=v;}
}
