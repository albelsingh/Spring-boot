package com.telusko.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telusko.springmvcboot.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

	// List<Alien> findByAnameOrderByAidDesc(String aname);  //Query DSL(Domail Specific language

	@Query("from Alien where aname= :name") 
	List<Alien> find(@Param("name") String aname);
}
