package com.codingdojo.com.dojoandninjas.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.com.dojoandninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{

	List<Dojo> findAll();
}
