package br.devhub.dto;

import java.io.Serializable;
import java.text.ParseException;

import org.springframework.data.domain.Sort.Direction;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseDTO<T> implements Serializable {

	private Boolean paginate;
	private Integer page;
	private Integer size;
	private Integer limit;
	private String[] by;
	private Direction direction;
	
	private static final long serialVersionUID = -3660767369020091229L;

	T toEntity() throws ParseException {
		return null;
	}
	
	
}
