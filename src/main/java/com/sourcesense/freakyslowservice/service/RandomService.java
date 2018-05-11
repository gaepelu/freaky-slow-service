package com.sourcesense.freakyslowservice.service;

import com.sourcesense.freakyslowservice.datatype.RandomObject;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RandomService {
	
	Mono<RandomObject> getRandomObject();

	Flux<RandomObject> getFluxOfRandomObject(Long limit);

	Mono<RandomObject> getRandomSlowObject(); 

}
