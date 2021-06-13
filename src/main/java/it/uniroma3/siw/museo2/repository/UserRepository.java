package it.uniroma3.siw.museo2.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo2.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Object findByUsername(String username);

	Object findByEmail(String email);

}