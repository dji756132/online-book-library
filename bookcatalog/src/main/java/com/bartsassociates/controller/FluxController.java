package com.bartsassociates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FluxController {

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("1st data", "2nd data", "3rd data").log();
    }
}
