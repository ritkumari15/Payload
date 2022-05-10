package com.payload.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="payload")
public class Payload {
	
	@Id
	private String loadId;
	
	@Column(name="loadingPoint")
	private String loadingPoint;
	
	@Column(name="unloadingPoint")
	private String unloadingPoint;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="truckType")
	private String truckType;
	
	@Column(name="noOfTruck")
	private Integer noOfTruck;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "payloads")
	private Set<ShipperEntity> set= new HashSet<>();
	
	public String getLoadId() {
		return loadId;
	}
	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}
	
	public Set<ShipperEntity> getSet() {
		return set;
	}
	public void setSet(Set<ShipperEntity> set) {
		this.set = set;
	}
	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public Integer getNoOfTruck() {
		return noOfTruck;
	}
	public void setNoOfTruck(Integer noOfTruck) {
		this.noOfTruck = noOfTruck;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

}
