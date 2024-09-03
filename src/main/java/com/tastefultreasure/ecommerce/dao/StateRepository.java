package com.tastefultreasure.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tastefultreasure.ecommerce.entity.State;


@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {
	//http://localhost:8080/states/search/findByCountryCode?code=IN
	List<State> findByCountryCode(@Param("code") String code);

}
