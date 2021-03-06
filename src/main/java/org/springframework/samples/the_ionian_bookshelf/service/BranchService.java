package org.springframework.samples.the_ionian_bookshelf.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.the_ionian_bookshelf.model.Branch;
import org.springframework.samples.the_ionian_bookshelf.repository.BranchRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	public BranchService(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}
	
	@Transactional
	public Collection<Branch> findAll(){
		return branchRepository.findAll();
	}
	
	@Transactional
	public void saveBranch(Branch branch) throws DataAccessException {
		this.branchRepository.save(branch);
	}
	
	@Transactional
	public void deleteBranch(Branch branch) throws DataAccessException {
		this.branchRepository.delete(branch);
	}
	
	@Transactional
	public Branch findBranchById(final int id) throws DataAccessException {
		return branchRepository.findById(id).get();
	}

}
