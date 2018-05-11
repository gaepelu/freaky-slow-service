package com.sourcesense.freakyslowservice.service.impl;

import java.time.Duration;
import java.util.UUID;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import com.sourcesense.freakyslowservice.datatype.RandomObject;
import com.sourcesense.freakyslowservice.service.RandomService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RandomServiceImpl implements RandomService {

	@Override
	public Mono<RandomObject> getRandomObject() {
		
		return Mono.just(randomObjectFactory()).delayElement(Duration.ofSeconds(5));
	}

	@Override
	public Flux<RandomObject> getFluxOfRandomObject(Long limit) {
		return Flux
				.fromStream(LongStream.range(0, limit).boxed())
				.map(n -> randomObjectFactory())
				.delaySequence(Duration.ofSeconds(5));
	}

	private RandomObject randomObjectFactory() {
		RandomObject randomObject = RandomObject
				.builder()
				.randomNumber(Math.random())
				.randomString(UUID.randomUUID().toString())
				.build();
		return randomObject;
	}

	@Override
	public Mono<RandomObject> getRandomSlowObject() {
		return Mono.just(randomObjectFactory()).delayElement(Duration.ofSeconds(10));
	}
}
