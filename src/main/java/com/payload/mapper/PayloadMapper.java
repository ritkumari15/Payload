package com.payload.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.payload.dto.ImmutablePayloadDto;
import com.payload.dto.PayloadDto;
import com.payload.entity.Payload;
import com.payload.entity.ShipperEntity;

public interface PayloadMapper {
	
	public static PayloadDto entityToDto(Payload payload)
	{
		return ImmutablePayloadDto.builder()
				.loadId(UUID.fromString(payload.getLoadId()))
				.comment(payload.getComment())
				.weight(payload.getWeight())
				.unLoadingPoint(payload.getUnloadingPoint())
				.loadingPoint(payload.getLoadingPoint())
				.noOfTruck(payload.getNoOfTruck())
				.productType(payload.getProductType())
				.truckType(payload.getTruckType())
				.date(new Date(payload.getDate().getTime()))
				.shipperList(stringToUuid(payload.getSet()))
				.build();
		
	}

	public static Set<UUID> stringToUuid(Set<ShipperEntity> list) {
		// TODO Auto-generated method stub
		Set<UUID> ls=new HashSet();
		for(ShipperEntity s:list)
		{
			ls.add(UUID.fromString(s.getShipperId()));
			
		}
		return ls;
	}

}
