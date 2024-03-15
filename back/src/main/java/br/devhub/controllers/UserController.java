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
import br.devhub.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping(path = "id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<UserDTO>> findById(@RequestBody UserDTO userTO) {
		var result = new ResponseDTO<>(true, 1, userService.findById(userTO));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
