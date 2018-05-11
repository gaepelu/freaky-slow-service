package com.sourcesense.freakyslowservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesense.freakyslowservice.datatype.RandomObject;
import com.sourcesense.freakyslowservice.service.RandomService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RandomController {
	
	@Autowired
	private RandomService randomService;
	
	@GetMapping("/random")
	public Mono<RandomObject> getRandomObject(){
		return randomService.getRandomObject();
	}
	
	@GetMapping("/random-slow")
	public Mono<RandomObject> getRandomSlowObject(){
		return randomService.getRandomSlowObject();
	}
	
	@GetMapping("/random/{limit}")
	public Flux<RandomObject> getFluxOfRandomObject(@PathVariable(required=true,name="limit") Long limit){
		return randomService.getFluxOfRandomObject(limit);
	}
	
}
