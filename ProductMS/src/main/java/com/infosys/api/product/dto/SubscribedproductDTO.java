package com.infosys.api.product.dto;

import com.infosys.api.product.entity.Subscribedproduct;

public class SubscribedproductDTO {

	Integer	buyerid;
	Integer prodid;
	Integer quantity;
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CartDTO [buyerid=" + buyerid + ", prodid=" + prodid + ", quantity=" + quantity + "]";
	}
	// Converts Entity into DTO
	public static SubscribedproductDTO valueOf(Subscribedproduct subscribed) {
		SubscribedproductDTO subsribedDTO = new SubscribedproductDTO();
		subsribedDTO.setBuyerid(subscribed.getBuyerid());
		subsribedDTO.setProdid(subscribed.getProdid());
		subsribedDTO.setQuantity(subscribed.getQuantity());	
		return subsribedDTO;
	}

	// Converts DTO into Entity
	public Subscribedproduct createEntity() {
		Subscribedproduct subscribed = new Subscribedproduct();	
		subscribed.setBuyerid(this.getBuyerid());
		subscribed.setProdid(this.getProdid());
		subscribed.setQuantity(this.getQuantity());
		return subscribed;
	}

}
