package br.devhub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.devhub.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query(nativeQuery = true, value = "SELECT * FROM gestao.pessoa WHERE email = :email")
	List<User> findByEmail(@Param("email") String email);
}
