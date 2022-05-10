package com.payload.services.Impl;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payload.dto.PayloadDto;
import com.payload.dto.ShipperDto;
import com.payload.entity.Payload;
import com.payload.entity.ShipperEntity;
import com.payload.mapper.PayloadMapper;
import com.payload.repository.PayloadRepository;
import com.payload.repository.SipperRepository;
import com.payload.services.PayloadServices;

@Service
public class PayloadServicesImpl implements PayloadServices{
    
	@Autowired
	private PayloadRepository payloadRepository;
	
	@Autowired
	private SipperRepository repository;
	
	
	@Override
	public PayloadDto add(PayloadDto payloadDto) {
		// TODO Auto-generated method stub
		Payload payload=new Payload();
		payload.setLoadId(UUID.randomUUID().toString());
		payload.setLoadingPoint(payloadDto.getLoadingPoint());
		payload.setUnloadingPoint(payloadDto.getUnLoadingPoint());
		payload.setNoOfTruck(payloadDto.getNoOfTruck());
		payload.setProductType(payloadDto.getProductType());
		payload.setTruckType(payloadDto.getTruckType());
		payload.setWeight(payloadDto.getWeight());
		payload.setComment(payloadDto.getComment());
		payload.setDate(new Date(payloadDto.getDate().getTime()));
		
		for(UUID id:payloadDto.getShipperList())
		{
			payload.getSet().add(repository.getById(id.toString()));
		}
		Payload payload2=payloadRepository.save(payload);
		
		
		
		return PayloadMapper.entityToDto(payload2);
	}

	@Override
	public PayloadDto get(String shipperid) {
		// TODO Auto-generated method stub
		
		return PayloadMapper.entityToDto(payloadRepository.getByShipperId(shipperid));
	}

	@Override
	public PayloadDto update(PayloadDto payloadDto, String loadId) {
		// TODO Auto-generated method stub
		Payload payload=payloadRepository.getById(loadId);
		payload.setLoadId(UUID.randomUUID().toString());
		payload.setLoadingPoint(payloadDto.getLoadingPoint());
		payload.setUnloadingPoint(payloadDto.getUnLoadingPoint());
		payload.setNoOfTruck(payloadDto.getNoOfTruck());
		payload.setProductType(payloadDto.getProductType());
		payload.setTruckType(payloadDto.getTruckType());
		payload.setWeight(payloadDto.getWeight());
		payload.setComment(payloadDto.getComment());
		payload.setDate(new Date(payloadDto.getDate().getTime()));
		
		for(UUID id:payloadDto.getShipperList())
		{
			payload.getSet().add(repository.getById(id.toString()));
		}
		Payload payload2=payloadRepository.save(payload);
		
		
		
		return PayloadMapper.entityToDto(payload2);
		
				
		
	}

	@Override
	public void delete(String shipperid) {
		// TODO Auto-generated method stub
		
		payloadRepository.deleteById(shipperid);
		
	}

	@Override
	public void addShipper(ShipperDto dto) {
		// TODO Auto-generated method stub
		ShipperEntity entity=new ShipperEntity();
		entity.setShipperId(UUID.randomUUID().toString());
		entity.setName(dto.getName());
		
		repository.save(entity);
	}

	
}
