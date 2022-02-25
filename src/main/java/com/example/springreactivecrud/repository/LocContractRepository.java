package com.example.springreactivecrud.repository;

import com.example.springreactivecrud.entity.LocContract;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocContractRepository extends ReactiveCrudRepository<LocContract,Long> {
    Flux<LocContract> getById(Long id);

    @Query("SELECT * from loc_contract l where l.id <= 10 ")
    public Flux<LocContract> findByIdLessThanEqual ();
}
