package it.uniroma3.siw.rentalev.repository;

import it.uniroma3.siw.rentalev.model.Role;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.rentalev.model.ERole;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(ERole roleCustomer);

}
