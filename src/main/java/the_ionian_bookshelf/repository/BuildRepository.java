package the_ionian_bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import the_ionian_bookshelf.model.Build;

public interface BuildRepository extends JpaRepository<Build, Integer> {
	
	Build findBuildById(int id);

	void removeBuildById(int id);
}

