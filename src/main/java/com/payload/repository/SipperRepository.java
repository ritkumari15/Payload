package com.payload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payload.entity.ShipperEntity;

@Repository
public interface SipperRepository extends JpaRepository<ShipperEntity, String> {

}
