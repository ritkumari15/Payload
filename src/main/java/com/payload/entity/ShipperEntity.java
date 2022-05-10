package com.payload.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="shipper")
public class ShipperEntity {
	
	@Id
	private String shipperId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "shipper_payload",
	joinColumns = { @JoinColumn(name = "shipper_id")},
	inverseJoinColumns = { @JoinColumn (name = "load_id")})
	private Set<Payload> payloads=new HashSet<>();




	public Set<Payload> getPayloads() {
		return payloads;
	}

	public void setPayloads(Set<Payload> payloads) {
		this.payloads = payloads;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
