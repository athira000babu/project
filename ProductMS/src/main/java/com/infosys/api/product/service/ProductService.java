package com.infosys.api.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.infosys.api.product.dto.ProductDTO;
import com.infosys.api.product.dto.SubscribedproductDTO;
import com.infosys.api.product.entity.Product;
import com.infosys.api.product.entity.Subscribedproduct;
import com.infosys.api.product.repository.ProductRepository;
import com.infosys.api.product.repository.SubscribedRepository;

@Service
public class ProductService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepo;

	@Autowired
	SubscribedRepository subscribedRepo;

	// Fetches all Product details
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}
		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}

	// Fetch specific products details by Name
	public ProductDTO getSpecificProductName(@PathVariable String productName) {
		logger.info("product request for customer {}", productName);
		return ProductDTO.valueOf(productRepo.findByProductName(productName));

	}

	// Fetch specific products details by category
	public List<ProductDTO> getSpecificCategory(@PathVariable String category) {
		logger.info("product request for customer {}", category);
		List<Product> productCategoryDetails = productRepo.findByCategory(category);
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		for (Product productListCategory : productCategoryDetails) {
			productDTO.add(ProductDTO.valueOf(productListCategory));
		}
		logger.info("product request for customer by Category : {}", productCategoryDetails);
		return productDTO;

	}

	// Update Product Stock
	public Product updateStock(Product product, Integer id) {
		Product existingProduct = productRepo.findById(id).orElse(null);
		if (existingProduct != null) {
			existingProduct.setStock(product.getStock());
			return productRepo.save(existingProduct);
		}
		return null;

	}

	// delete Product by seller ID
	public void deleteProduct(Integer sellerid) throws Exception {
		Optional<Product> product = productRepo.findById(sellerid);
		product.orElseThrow(() -> new Exception("API.PRODUCT_NOT_FOUND"));
		productRepo.deleteById(sellerid);
	}

	// Add Product ToSubscribedList
	public int addProductToSubscribedList(SubscribedproductDTO subscribedDTO) throws Exception {
		Subscribedproduct subscribedList1 = new Subscribedproduct();
		subscribedList1.setBuyerid(subscribedDTO.getBuyerid());
		subscribedList1.setProdid(subscribedDTO.getProdid());
		subscribedList1.setQuantity(subscribedDTO.getQuantity());
		Subscribedproduct returnwishlist = subscribedRepo.save(subscribedList1);
		return returnwishlist.getBuyerid();
	}

	// Fetch specific Product details
	public ProductDTO getSpecificProduct(Integer prodid) throws Exception {
		logger.info("Product details : {}", prodid);
		Optional<Product> product = productRepo.findById(prodid);
		product.orElseThrow(() -> new Exception("Product is NOT Found"));
		return ProductDTO.valueOf(productRepo.findByProdid(prodid));
	}

	// Get Specific Subscribed Product
	public List<SubscribedproductDTO> getByBuyerid(Integer buyerid) {

		logger.info("Productname request for product {}", buyerid);
		List<Subscribedproduct> sub = subscribedRepo.findByBuyerid(buyerid);
		List<SubscribedproductDTO> subscribedprodDTO = new ArrayList<SubscribedproductDTO>();
		for (Subscribedproduct subs : sub) {
			subscribedprodDTO.add(SubscribedproductDTO.valueOf(subs));
		}
		logger.info("Productname for product : {}", sub);
		return subscribedprodDTO;
	}
	
	public List<SubscribedproductDTO> getAllSubscriptionList() {
		List<Subscribedproduct> subList = subscribedRepo.findAll();
		logger.info("Get All Subscription {} ",subList);
		List<SubscribedproductDTO> subscribedprodDTO = new ArrayList<SubscribedproductDTO>();
		for (Subscribedproduct subs : subList) {
			subscribedprodDTO.add(SubscribedproductDTO.valueOf(subs));
		}
		return subscribedprodDTO;
	}


}
