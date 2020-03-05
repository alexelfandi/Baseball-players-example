package com.baseball.Baseball.Players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/player")
public class Controller {

    @Autowired
    private PlayerRepository repository;

    @GetMapping("{id}")
    Mono<ResponseEntity<Player>> getById(@PathVariable(value = "id") String id){
        return this.repository.findById(id)
                .map(player -> ResponseEntity.ok(player))
                .defaultIfEmpty(ResponseEntity.notFound().build());


    }

    @PostMapping()
    Mono<Player> createPlayer(@RequestBody Player newPlayer){
        return this.repository.save(newPlayer);
    }


}
