package com.ty.fetchingcsvdataapplication.service;

import java.util.List;

import com.ty.fetchingcsvdataapplication.pojo.Store;

public interface StoreService {

	public Store getStoreById(String id);

	public List<Store> getStoresByCity(String city);

}
