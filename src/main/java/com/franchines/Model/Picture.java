package com.franchines.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Picture {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String pictureAuthor;
	private String pictureName;
	private double price;
	private Date dateReg;
	
	@ManyToOne(cascade = CascadeType.REMOVE)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "shop_id")
	private Shop shop;
	
	public Picture() {}
		
	public Picture(String pictureName, double price, Shop shop) {
		super();
		this.pictureName = pictureName;
		this.pictureAuthor = "Anonymous";		
		this.price = price;
		this.dateReg = new Date();
		this.shop = shop;
	}
				
	public Picture(String pictureName, String pictureAuthor, double price, Shop shop) {
		super();
		this.pictureName = pictureName;
		this.pictureAuthor = pictureAuthor;		
		this.price = price;
		this.dateReg = new Date();
		this.shop = shop;
	}
			
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getPictureAuthor() {
		return pictureAuthor;
	}

	public void setPictureAuthor(String pictureAuthor) {
		this.pictureAuthor = pictureAuthor;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateReg() {
		return dateReg;
	}

	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateReg == null) ? 0 : dateReg.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pictureAuthor == null) ? 0 : pictureAuthor.hashCode());
		result = prime * result + ((pictureName == null) ? 0 : pictureName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (dateReg == null) {
			if (other.dateReg != null)
				return false;
		} else if (!dateReg.equals(other.dateReg))
			return false;
		if (id != other.id)
			return false;
		if (pictureAuthor == null) {
			if (other.pictureAuthor != null)
				return false;
		} else if (!pictureAuthor.equals(other.pictureAuthor))
			return false;
		if (pictureName == null) {
			if (other.pictureName != null)
				return false;
		} else if (!pictureName.equals(other.pictureName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", pictureAuthor=" + pictureAuthor + ", pictureName=" + pictureName + ", price="
				+ price + ", dateReg=" + dateReg + ", shop=" + shop + "]";
	}
	
}
