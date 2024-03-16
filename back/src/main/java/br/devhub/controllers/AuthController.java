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
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userTO) {
		return new ResponseEntity<>(authService.register(userTO), HttpStatus.OK);
	}
	
	@PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userTO) {
		return new ResponseEntity<>(authService.login(userTO), HttpStatus.OK);
	}
}
