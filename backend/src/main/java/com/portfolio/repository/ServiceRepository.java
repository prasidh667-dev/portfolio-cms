package com.portfolio.repository;
import com.portfolio.model.Service; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ServiceRepository extends JpaRepository<Service,Long> { List<Service> findAllByOrderByDisplayOrderAsc(); }
