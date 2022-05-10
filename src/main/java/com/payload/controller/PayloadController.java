package com.payload.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.dto.PayloadDto;
import com.payload.dto.ShipperDto;
import com.payload.services.PayloadServices;

@RestController
@RequestMapping("/payload")
public class PayloadController {
	
	@Autowired
	private PayloadServices payloadServices;
	
	@PostMapping("/load")
	public ResponseEntity<?> create(@RequestBody PayloadDto payloadDto)
	{
	   PayloadDto payloadDto2=payloadServices.add(payloadDto);
	   
	   if(payloadDto2==null)
	   {
		   return new ResponseEntity<String>("Error",HttpStatus.BAD_REQUEST);
	   }	   
	   
	   return new ResponseEntity<PayloadDto>(payloadDto2,HttpStatus.ACCEPTED);
	     
	   
	}
	
	@PostMapping("/shipper")
	public ResponseEntity<?> createShipper(@RequestBody ShipperDto shipperDto)
	{
	  payloadServices.addShipper(shipperDto);
	   
	  
	   return new ResponseEntity<String>("Created",HttpStatus.ACCEPTED);
	     
	   
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getPayload(@PathVariable("id") UUID id){
	    PayloadDto dto=payloadServices.get(id.toString());
		if (dto==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PayloadDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/update/{loadId}")
	public ResponseEntity<?> updatePayload(@RequestBody PayloadDto payloadDto,@PathVariable("loadId") UUID loadId){
		PayloadDto dto = payloadServices.update(payloadDto, loadId.toString());
		if (dto==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PayloadDto>(dto, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{loadId}")
	public ResponseEntity<?> deletek(@PathVariable("loadId") UUID id){
		payloadServices.delete(id.toString());
		
		return new ResponseEntity<PayloadDto>( HttpStatus.OK);
	}
	
}
