package com.portfolio.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.model.Message;
import com.portfolio.repository.MessageRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final MessageRepository repo;

    ContactController(MessageRepository r) {
        repo = r;
    }

    @PostMapping
    public Message create(@Valid @RequestBody Message m) {
        return repo.save(m);
    }

    @GetMapping
    public List<Message> all() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}