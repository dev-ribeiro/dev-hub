package br.devhub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.devhub.dto.ResponseDTO;
import br.devhub.dto.UserDTO;
import br.devhub.services.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<UserDTO>> register(@RequestBody UserDTO userTO) {
		var result = new ResponseDTO<UserDTO>(true, 1, authService.register(userTO));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<UserDTO>> login(@RequestBody UserDTO userTO) {
		var result = new ResponseDTO<UserDTO>(true, 1, authService.login(userTO));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
