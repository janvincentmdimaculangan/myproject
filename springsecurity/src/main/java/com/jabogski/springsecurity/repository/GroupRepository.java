package com.jabogski.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jabogski.springsecurity.model.Group;


@Repository
public interface GroupRepository extends CrudRepository<Group, Long>{
 
}
