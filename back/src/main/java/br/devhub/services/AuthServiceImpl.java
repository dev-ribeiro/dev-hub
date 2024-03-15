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
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	public UserDTO register(UserDTO userTO) {
		var user = userTO.toEntity();
		var entity = userRepository.save(user);
		return entity.toDTO();
	}

	public UserDTO login(UserDTO userTO) throws UserException {
		var query = userRepository.findByEmail(userTO.getEmail());
		if (query.isEmpty())
			throw new UserException("Não foi possível recuperar o usuário");
		var entity = query.get(0);
		return entity.toDTO();
	}

}
