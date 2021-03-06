package org.springframework.samples.the_ionian_bookshelf.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.the_ionian_bookshelf.model.Branch;
import org.springframework.samples.the_ionian_bookshelf.model.Build;
import org.springframework.samples.the_ionian_bookshelf.model.Rune;
import org.springframework.samples.the_ionian_bookshelf.model.RunePage;
import org.springframework.samples.the_ionian_bookshelf.repository.BranchRepository;
import org.springframework.samples.the_ionian_bookshelf.repository.BuildRepository;
import org.springframework.samples.the_ionian_bookshelf.repository.RunePageRepository;
import org.springframework.samples.the_ionian_bookshelf.repository.RuneRepository;
import org.springframework.stereotype.Service;

@Service
public class RuneService {

	@Autowired
	private RuneRepository runeRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private RunePageRepository runePageRepository;
	
	@Autowired
	private AuthoritiesService authService;
	
	@Autowired
	private BuildRepository buildRepository;
	
	@Autowired
	public RuneService(RuneRepository runeRepository, BranchRepository branchRepository, RunePageRepository runePageRepository, BuildRepository buildRepository) {
		this.runeRepository = runeRepository;
		this.branchRepository = branchRepository;
		this.runePageRepository = runePageRepository;
		this.buildRepository = buildRepository;
	}


	@Transactional
	public Collection<Rune> findAll(){
		return runeRepository.findAll();
	}
	
	@Transactional
	public void saveRune(Rune rune) throws DataAccessException {
		assertNotNull(rune);
		assertTrue(this.authService.checkAuthorities("administrator"));
		this.runeRepository.save(rune);
	}
	
	@Transactional
	public void deleteRune(Rune rune) throws DataAccessException {
		assertNotNull(rune);
        Collection<RunePage> runePages = this.runePageRepository.findAllByRune(rune.getId());
        List<Build> builds = runePages.stream().map(x-> this.buildRepository.findAllByRunePage(x.getId())).flatMap(x->x.stream()).collect(Collectors.toList());
        builds.forEach(x->this.buildRepository.delete(x));
        runePages.forEach(x->this.runePageRepository.delete(x));
        this.runeRepository.delete(rune);
	}
	
	//Forma como está puesto el PetType
	@Transactional()
	public Collection<Branch> findBranches() throws DataAccessException {
		return this.branchRepository.findAll();
	}

	@Transactional
	public Rune findRuneById(final int id) throws DataAccessException {
		return runeRepository.findById(id).get();
	}
	

	
}
