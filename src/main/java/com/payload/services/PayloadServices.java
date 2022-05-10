package com.payload.services;

import com.payload.dto.PayloadDto;
import com.payload.dto.ShipperDto;

public interface PayloadServices {
	
    public PayloadDto add(PayloadDto payloadDto);
	
	public PayloadDto get(String shipperid);
	
	public PayloadDto update(PayloadDto payloadDto, String loadId);
	
	public void delete(String shipperid);
    
	 public void addShipper(ShipperDto dto);
}
