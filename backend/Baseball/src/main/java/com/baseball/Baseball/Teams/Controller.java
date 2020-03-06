package com.baseball.Baseball.Teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/team")
public class Controller {
    @Autowired
    private TeamRepository repository;

    @GetMapping()
    Flux<ResponseEntity<Team>> getAllTeams(){
        return this.repository.findAll()
                .map(team -> ResponseEntity.ok(team))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping("{id}")
    Mono<ResponseEntity<Team>> getTeamById(@PathVariable(value="id") String id){
        return this.repository.findById(id)
                .map(team -> ResponseEntity.ok(team))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping()
    Mono<ResponseEntity<Team>> newTeam(@RequestBody Team newTeam){
        return this.repository.save(newTeam)
                .map(newVenta -> ResponseEntity.ok(newVenta));
    }
    @DeleteMapping("{id}")
    Mono<ResponseEntity<Team>> deleteTeam(@PathVariable(value = "id") String id){
        return this.repository.findById(id)
                .flatMap(team -> this.repository.delete(team)
                    .then(Mono.just(new ResponseEntity<Team>(team , HttpStatus.OK))))
                        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
