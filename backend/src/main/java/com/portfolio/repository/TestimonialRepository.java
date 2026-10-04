package com.portfolio.repository;
import com.portfolio.model.Testimonial; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface TestimonialRepository extends JpaRepository<Testimonial,Long> { List<Testimonial> findAllByOrderByDisplayOrderAsc(); }
