package com.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.model.About;
import com.portfolio.repository.AboutRepository;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private static final long PROFILE_ID = 1L;

    private final AboutRepository repo;

    AboutController(AboutRepository r) {
        repo = r;
    }

    @GetMapping
    public About get() {
        return repo.findById(PROFILE_ID)
                .orElseGet(() -> repo.save(new About()));
    }

    @PutMapping
    public About update(@RequestBody About a) {

        About profile = repo.findById(PROFILE_ID).orElseGet(About::new);
        profile.setId(PROFILE_ID);
        profile.setName(a.getName());
        profile.setHeadline(a.getHeadline());
        profile.setBio(a.getBio());
        profile.setEmail(a.getEmail());
        profile.setLocation(a.getLocation());

        return repo.save(profile);
    }
}