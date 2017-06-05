package com.zheng.service;

import com.zheng.repository.InventoryRepository;
import com.zheng.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class WmsService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	RecordsRepository recordsRepository;

	public String buy(int userId) {
		return "buy:" + userId;
	}

}
