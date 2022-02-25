package com.example.springreactivecrud.service;

import com.example.springreactivecrud.entity.LocContract;
import com.example.springreactivecrud.repository.LocContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocContractService {
    private final LocContractRepository locContractRepository;

    public Flux<LocContract> getAll() {
        return locContractRepository.findAll();
    }
        public Mono<LocContract> saveLocContract(LocContract locContract){
            return locContractRepository.save(locContract);
        }
    public Flux<LocContract> getById(Long id){
        return locContractRepository.getById(id);
    }
    public Mono<Void> deleteById(Long id){ return  locContractRepository.deleteById(id);}
   public Flux<LocContract> getFirst10Id(){
        return locContractRepository.findFirst10();
   }
}
