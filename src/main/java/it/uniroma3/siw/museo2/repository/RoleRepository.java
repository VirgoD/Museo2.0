package it.uniroma3.siw.museo2.repository;

import it.uniroma3.siw.museo2.model.Role;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo2.model.ERole;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(ERole roleCustomer);

}
