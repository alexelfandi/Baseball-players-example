package com.baseball.Baseball.Players;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/player")
public class Controller {
    private PlayerRepository repository;
    @GetMapping("/{id}")
    Mono<Player> getById(@PathVariable(value = "id") String id){
        return this.repository.findById(id);
    }

    @PostMapping()
    Mono<Player> createPlayer(@RequestBody Player newPlayer){
        return this.repository.save(newPlayer);
    }


}
