package com.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import org.immutables.value.Value;

@JsonSerialize
@JsonDeserialize(as = ImmutablePayloadDto.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface PayloadDto {
	
	@Nullable
	UUID getLoadId();
	
	@NotNull
	String getLoadingPoint();
	
	@NotNull
	String getUnLoadingPoint();
	
	@NotNull
	String getProductType();
	
	@NotNull
	String getTruckType();
	
	@NotNull
	Double getWeight();
	
	@NotNull
	Date getDate();
	
	@NotNull
	Integer getNoOfTruck();
	
	@Nullable
	String getComment();
	
	@Nullable
	List<UUID> getShipperList();
	

}
