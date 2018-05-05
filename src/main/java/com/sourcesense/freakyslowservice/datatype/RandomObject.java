package com.sourcesense.freakyslowservice.datatype;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Getter
@Setter
@ToString
public class RandomObject {
	private Double randomNumber;
	private String randomString;
}
