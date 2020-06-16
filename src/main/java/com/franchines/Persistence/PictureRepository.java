package com.franchines.Persistence;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.franchines.Model.Picture;
import com.franchines.Model.Shop;

public interface PictureRepository extends JpaRepository<Picture, Long> {
		
	@Query("SELECT p from Picture p where p.shop = :shop")
	List<Picture> findAllByShop(@Param("shop") Shop shop);
	
	@Query("SELECT COUNT(p) from Picture p where p.shop = :shop")
	int countPicturesByShop(@Param("shop") Shop shop);
		
	@Modifying
	@Transactional
	@Query("DELETE FROM Picture p WHERE p.shop = :shop")
	void deleteAllPicturesInShop(@Param("shop") Shop shop);

}
