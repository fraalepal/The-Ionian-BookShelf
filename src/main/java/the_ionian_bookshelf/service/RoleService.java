package the_ionian_bookshelf.service;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the_ionian_bookshelf.model.Role;
import the_ionian_bookshelf.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private AdministratorService adminService;

	public Role findDefaultRole() {

		this.adminService.findByPrincipal();

		Role res = this.roleRepo.findDefaultRole();
		assertNotNull(res);

		return res;
	}

}
