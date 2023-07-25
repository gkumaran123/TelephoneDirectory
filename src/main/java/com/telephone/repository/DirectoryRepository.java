package com.telephone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telephone.entity.Directory;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {
	
	@Query("SELECT d FROM Directory d WHERE d.name LIKE %?1%")
	List<Directory> findByName(String name);

}
