package br.devhub.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = -4138707583023408373L;

	private Boolean success;
	
	private Integer numberOfElements;
	
	private T response;
}
