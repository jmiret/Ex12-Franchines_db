package com.franchines.Controller;

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
		
	// readerAllPictures
	@GetMapping("/pictures")
	List<Picture> readerAllPictures() {
		return pictureRepository.findAll();
	}
	
	// createPicture
		@PostMapping("/shops/{id}/pictures")
		Picture createPicture(@RequestBody Picture newPicture, @PathVariable Long id) throws Exception {
			int nowPicturesInShop = pictureRepository.countPicturesByShop(shopRepository.findShopById(id));
			int maxPicturesNumberInShop = shopRepository.findShopById(id).getPicturesNumber();
		
			if(nowPicturesInShop < maxPicturesNumberInShop) {
			
				// El constructor no controla el objecto instanciado???
				if(newPicture.getPictureAuthor() == null) {
					newPicture.setPictureAuthor("Anonymous");
				}
				
				newPicture.setShop(shopRepository.findShopById(id));
				newPicture.setDateReg(new Date());
				//pictureRepository.createPicture(newPicture, shopRepository.findShopById(id));
				return pictureRepository.save(newPicture);
			} else {
				 throw new CustomException("Exceede pictures number.");
			}
		}
			
		// readerAllPicturesInShop	
		@GetMapping("/shops/{id}/pictures")
		List<Picture> readerAllPicturesInShop(Shop shop, @PathVariable Long id) {
			//shop.setName(shop.getName());
			shop.setId(shop.getId());
			return pictureRepository.findAllByShop(shop);
		}
		
		// deleteAllPicturesInShop	
		@DeleteMapping("/shops/{id}/pictures")
		void deleteAllPicturesInShop(Shop shop, @PathVariable Long id) {
			shop.setName(shop.getName());
			pictureRepository.deleteAllPicturesInShop(shop);
		}
}
