package br.devhub.services;

import br.devhub.dto.UserDTO;
import br.devhub.models.User;

public interface AuthService {
	
	UserDTO register(UserDTO userTO);
	
	UserDTO login(UserDTO userTO);
}
