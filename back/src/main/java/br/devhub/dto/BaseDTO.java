package br.devhub.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseDTO<T> implements Serializable {

	private Integer page;
	
	private Integer limit;
	
	private static final long serialVersionUID = -3660767369020091229L;

	T toEntity() {
		return null;
	}
	
	
}
