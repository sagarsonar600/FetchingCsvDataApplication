package com.ty.fetchingcsvdataapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fetchingcsvdataapplication.pojo.Store;
import com.ty.fetchingcsvdataapplication.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("/getStoreById/{storeId}")
	public ResponseEntity getStoreById(@PathVariable String storeId) {
		Store storeById = service.getStoreById(storeId);
		if (storeById != null)
			return new ResponseEntity(storeById, HttpStatus.OK);
		else
			return new ResponseEntity("Records not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getStoresByField/{field}")
	public ResponseEntity getStoresByField(@PathVariable String field) {
		List<Store> storesByCity = service.getStoresByCity(field);
		if (!storesByCity.isEmpty()) {
			return new ResponseEntity(storesByCity, HttpStatus.OK);
		} else {
			return new ResponseEntity("No Records Found", HttpStatus.NOT_FOUND);
		}
	}

}
