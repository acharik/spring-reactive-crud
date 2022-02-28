package com.example.springreactivecrud.repository;

import com.example.springreactivecrud.entity.LocContract;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface LocContractRepository extends ReactiveCrudRepository<LocContract,Long> {
    Flux<LocContract> getById(Long id);

        @Query("SELECT * from loc_contract LIMIT $1 ")
        Flux<LocContract> findFirstNContract(Long count);
        Flux<LocContract> findByDateBeginAfter(LocalDate date);
        @Query("SELECT * FROM loc_contract  WHERE date_begin >=$1 LIMIT $2 ")
        Flux<LocContract> findFirstNContractAndAfterRequiredDate(LocalDate date, Long count);
        Mono<LocContract> findByNumContract(String num);
}
