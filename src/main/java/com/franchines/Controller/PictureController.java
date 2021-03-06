package com.franchines.Controller;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franchines.Model.Picture;
import com.franchines.Model.Shop;
import com.franchines.Persistence.PictureRepository;
import com.franchines.Persistence.ShopRepository;
import com.franchines.Exceptions.CustomException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PictureController {
	
	private final PictureRepository pictureRepository;
	private final ShopRepository shopRepository;
	
	public PictureController(PictureRepository pictureRepository, ShopRepository shopRepository) {		
		super();
		this.pictureRepository = pictureRepository;
		this.shopRepository = shopRepository;
	}
		
	/**
	 * readerAllPictures	 * 
	 * @return
	 */	
	@GetMapping("/pictures")
	List<Picture> readerAllPictures() {
		return pictureRepository.findAll();
	}
	
	/**
	 * createPicture	 * 
	 * @param p
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/shops/{id}/pictures")
	Picture createPicture(@RequestBody Picture p, @PathVariable Long id) throws Exception {
		
		int nowPicturesInShop;
		int maxPicturesNumberInShop;
				
		nowPicturesInShop = pictureRepository.countPicturesByShop(shopRepository.findShopById(id));
		maxPicturesNumberInShop = shopRepository.findShopById(id).getPicturesNumber();
			
		if(nowPicturesInShop < maxPicturesNumberInShop) {
			
			if(p.getPictureAuthor() == null) {
				p = new Picture(p.getPictureName(), p.getPrice(), p.getShop());
			} else {
				p = new Picture(p.getPictureName(), p.getPictureAuthor(), p.getPrice(), p.getShop());
			}
			
			p.setShop(shopRepository.findShopById(id));
			p.setDateReg(new Date());
			return pictureRepository.save(p);
		} else {
			 throw new CustomException("Exceede pictures number.");
		}		
	
	}
			
	/**
	 * readerAllPicturesInShop	
	 * @param shop
	 * @param id
	 * @return
	 */		
	@GetMapping("/shops/{id}/pictures")
	List<Picture> readerAllPicturesInShop(Shop shop, @PathVariable Long id) {
		shop.setId(shop.getId());
		return pictureRepository.findAllByShop(shop);
	}
	
	/**
	 * deleteAllPicturesInShop	
	 * @param shop
	 * @param id
	 */
	@DeleteMapping("/shops/{id}/pictures")
	void deleteAllPicturesInShop(Shop shop, @PathVariable Long id) {
		shop.setName(shop.getName());
		pictureRepository.deleteAllPicturesInShop(shop);
	}
	
}
