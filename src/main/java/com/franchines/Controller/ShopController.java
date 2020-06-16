package com.franchines.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franchines.Exceptions.ShopNotFoundException;
import com.franchines.Model.Shop;
import com.franchines.Persistence.ShopRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ShopController {
		
	private final ShopRepository shopRepository;
	
	public ShopController(ShopRepository repository) {
		super();
		this.shopRepository = repository;
	}
	
	// createShop
	@PostMapping("/shops")
	Shop createShop(@RequestBody Shop newShop) {
		return shopRepository.save(newShop);
	}
		
	// readerShop
	@GetMapping("/shops/{id}")
	Shop readerShop(@PathVariable Long id) {
		return shopRepository.findById(id)
				.orElseThrow(() -> new ShopNotFoundException(id));
	}
	
	// updateShop
	@PutMapping("/shops/{id}")
	Shop updateShop(@RequestBody Shop newShop, @PathVariable Long id) {

		return shopRepository.findById(id).map(shop -> {
			shop.setName(newShop.getName());
			shop.setPicturesNumber(newShop.getPicturesNumber());
			return shopRepository.save(shop);
		}).orElseThrow(() -> {
			return new ShopNotFoundException(id);
		//}).orElseGet(() -> {
			//newShop.setId(id);
			//return shopRepository.save(newShop);
		});
	}
	
	// deleteAllShops
	@DeleteMapping("/shops")
	void deleteAllShops() {
		shopRepository.deleteAllInBatch();
	}	
	
	// readerAllShops
	@GetMapping("/shops")
	List<Shop> allShops() {
		return shopRepository.findAll();
	}
	
}
