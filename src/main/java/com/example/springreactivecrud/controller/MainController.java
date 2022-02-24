package com.example.springreactivecrud.controller;

import com.example.springreactivecrud.entity.LocContract;
import com.example.springreactivecrud.repository.LocContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final LocContractRepository locContractRepository;

    @GetMapping
    public Flux<LocContract> getCatalogueItemsStream() {
        return locContractRepository
                .findAll()
                .delayElements(Duration.ofMillis(200));
    }
 }


