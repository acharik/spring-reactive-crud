package com.example.springreactivecrud.service;

import com.example.springreactivecrud.entity.LocContract;
import com.example.springreactivecrud.repository.LocContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LocContractService {
    private final LocContractRepository locContractRepository;

        public Mono<LocContract> saveLocContract(LocContract locContract){
            return locContractRepository.save(locContract);
        }
    public Flux<LocContract> getById(Long id){
        return locContractRepository.getById(id);
    }
    public Mono<Void> deleteById(Long id){ return  locContractRepository.deleteById(id);}
    public Mono<LocContract> getContractByNum(String num){return locContractRepository.findByNumContract(num);}
    public Flux<LocContract> getContract(LocalDate date, Long count){
        if(date == null){
            return locContractRepository.findFirstNContract(count);
        }
        if(count == null){
            return locContractRepository.findByDateBeginAfter(date);
        }
        return locContractRepository.findFirstNContractAndAfterRequiredDate(date,count);
    }
}
