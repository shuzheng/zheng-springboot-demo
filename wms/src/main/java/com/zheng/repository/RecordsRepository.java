package com.zheng.repository;

import com.zheng.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Inventory, Integer> {

}
