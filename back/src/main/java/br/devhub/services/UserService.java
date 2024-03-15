package br.devhub.services;

import br.devhub.dto.UserDTO;

public interface UserService {
	UserDTO findById(UserDTO userTO);
}
