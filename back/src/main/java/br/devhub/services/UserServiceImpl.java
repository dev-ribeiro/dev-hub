package br.devhub.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.devhub.dto.UserDTO;
import br.devhub.repositories.UserRepository;
import br.devhub.utils.exceptions.UserException;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserDTO findById(UserDTO userTO) {
		var entity = userRepository.findById(userTO.getId());
		if(!entity.isPresent()) throw new UserException("Não foi possível localizar o usuário.");
		return entity.get().toDTO();
	}
	
	
}
