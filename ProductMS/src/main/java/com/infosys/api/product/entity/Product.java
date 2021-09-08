package com.infosys.api.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
    @Column(name = "prodid", nullable = false)
    Integer prodid;
    @Column(name = "productname", nullable = false, length = 50)
    String productName;
    @Column(name="price", nullable=false)
    Double price;
    @Column(name = "stock", nullable = false)
    Integer stock;
    @Column(name = "description", nullable = false, length=500)
    String description;
    @Column(name = "image", nullable = false, length=255)
    String image;
    @Column(name = "sellerid", nullable = false)
    Integer sellerid;
    @Column(name = "category", nullable = false, length=25)
    String category;
    @Column(name = "subcategory", nullable = false, length=25)
    String subcategory;
    @Column(name = "productrating", nullable = false)
    Integer productrating;
    
        public Product() {
        super();
        }

		public Integer getProdid() {
			return prodid;
		}

		public void setProdid(Integer prodid) {
			this.prodid = prodid;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Integer getSellerid() {
			return sellerid;
		}

		public void setSellerid(Integer sellerid) {
			this.sellerid = sellerid;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getSubcategory() {
			return subcategory;
		}

		public void setSubcategory(String subcategory) {
			this.subcategory = subcategory;
		}

		public Integer getProductrating() {
			return productrating;
		}

		public void setProductrating(Integer productrating) {
			this.productrating = productrating;
		}
        
	

	
}
