package com.example.springreactivecrud.repository;

import com.example.springreactivecrud.entity.LocContract;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LocContractRepository extends ReactiveCrudRepository<LocContract,Long> {

}
