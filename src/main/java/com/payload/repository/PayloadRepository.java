package com.payload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payload.entity.Payload;

@Repository
public interface PayloadRepository extends JpaRepository<Payload,String> {
	@Query("select p from payload p where p.shipperId=?1")
	public Payload getByShipperId(String id);
	

	
}
