package com.baseball.Baseball.Players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/player")
public class PlayersController {

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

    /*@PutMapping()
    Mono<Player> updatePlayer*/

    @DeleteMapping("{id}")
    Mono<ResponseEntity<Player>> deletePlayer(@PathVariable(value = "id") String id){
        return this.repository.findById(id)
                .flatMap(player -> this.repository.delete(player)
                        .then(Mono.just(new ResponseEntity<Player>(player , HttpStatus.OK))))
                            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
