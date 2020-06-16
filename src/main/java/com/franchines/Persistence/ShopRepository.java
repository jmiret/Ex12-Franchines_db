package com.franchines.Persistence;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.franchines.Model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	@Query(value = "SELECT s from Shop s where s.id = ?1", nativeQuery = false)
	Shop findShopById(@Param("shopId") Long id);

}
