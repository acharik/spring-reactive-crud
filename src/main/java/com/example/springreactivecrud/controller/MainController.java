package com.example.springreactivecrud.controller;

import com.example.springreactivecrud.entity.LocContract;
import com.example.springreactivecrud.service.LocContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class MainController {

    private final LocContractService locContractService;

    @GetMapping("/all")
    public Flux<LocContract> getCatalogueItemsStream() {
        return locContractService
                .getAll();
    }
    @PostMapping("/add")
    public Mono<LocContract> add ( @RequestBody LocContract locContract){
        return locContractService.saveLocContract(locContract);
    }
    @GetMapping("/{id}")
    public Flux<LocContract> getById( @PathVariable("id") Long id){

        return locContractService.getById(id);}
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id){

        return locContractService.deleteById(id);
    }

    @PutMapping("/{id}")
    Mono<LocContract> updateLocContract(@RequestBody LocContract locContract, @PathVariable("id") Long id){
        locContract.setId(id);
        return locContractService.saveLocContract(locContract);
    }
    @GetMapping("/first10")
    public Flux<LocContract> getFirst10(){
        return locContractService.getFirst10Id();
    }

    @GetMapping("/dateFilter")
    public Flux<LocContract> getLocContractAfterRequiredDate(@RequestParam
                                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                          LocalDate date){
        return locContractService.getLocContractAfterRequiredDate(date);
    }

}


