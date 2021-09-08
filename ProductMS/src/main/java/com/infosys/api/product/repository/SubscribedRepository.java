package com.infosys.api.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.api.product.entity.Subscribedproduct;

public interface SubscribedRepository extends JpaRepository<Subscribedproduct, Integer> {
	
	List<Subscribedproduct> findByBuyerid(Integer buyerid);


}