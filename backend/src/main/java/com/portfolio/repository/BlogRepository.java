package com.portfolio.repository;
import com.portfolio.model.Blog; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface BlogRepository extends JpaRepository<Blog,Long> { List<Blog> findAllByOrderByDisplayOrderAsc(); }
