package com.infosys.api.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.infosys.api.product.composite.SubscribedProduct;

@Entity
@IdClass(SubscribedProduct.class)
public class Subscribedproduct {
	@Id
	@Column(name="buyerid", nullable=false)
	Integer buyerid;
	@Id
	@Column(name="prodid", nullable=false)
	Integer prodid;
	@Column(name="quantity", nullable=false)
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
	public Subscribedproduct() {
		super();
		
	}
	
	
	
}