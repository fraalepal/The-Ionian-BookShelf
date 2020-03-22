package the_ionian_bookshelf.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the_ionian_bookshelf.model.League;
import the_ionian_bookshelf.model.Thread;
import the_ionian_bookshelf.repositories.LeagueRepository;

@Service
@Transactional
public class LeagueService {

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private AdministratorService adminService;

	@Autowired
	private ThreadService threadService;

	public League create() {

		League res = new League();
		this.adminService.findByPrincipal();

		Thread thread = this.threadService.create();

		res.setName("New League");
		res.setThread(thread);

		return res;
	}

	public League findOne(int id) {

		assertTrue(id != 0);
		League res = this.leagueRepository.findById(id).get();

		assertNotNull(res);
		return res;
	}

	public Collection<League> findAll() {

		Collection<League> res = this.leagueRepository.findAll();
		assertTrue(!res.isEmpty());

		return res;
	}

	public League save(League league) {

		assertNotNull(league);

		this.adminService.findByPrincipal();

		League saved = this.leagueRepository.save(league);

		return saved;
	}

	public void delete(League league) {

		assertNotNull(league);

		this.adminService.findByPrincipal();

		this.leagueRepository.delete(league);
	}
	
	public League findDefaultLeague() {
		
		League res = this.leagueRepository.findDefaultLeague();
		assertNotNull(res);
		
		return res;
	}

}