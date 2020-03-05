package com.baseball.Baseball.Players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/page")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class PageableController {
    @Autowired
    private PageableRepository repository;
    @GetMapping()
    private Page<Player> getAllPlayers(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                             @RequestParam(name = "size", defaultValue = "10") Integer size){
        System.out.println("Hola");
        return this.repository.findAll(PageRequest.of(page,size));
        //.map( fvfv -> ResponseEntity.ok());
        // .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
