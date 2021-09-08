package com.infosys.api.product.controller;

import java.util.List;
import org.springframework.core.env.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import com.infosys.api.product.dto.ProductDTO;
import com.infosys.api.product.dto.SubscribedproductDTO;
import com.infosys.api.product.entity.Product;
import com.infosys.api.product.service.ProductService;
//import com.infosys.api.user.dto.BuyerDTO;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	@Autowired
    Environment environment;
//	@Autowired
//	RestTemplate restTemplate;
	
//	@Value("${buyer.uri}")
//	String buyerUri;


	// Fetches all plan details
	@GetMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProduct() {
		logger.info("Fetching all products");
		return productService.getAllProducts();
	}

	// Fetch product details of a specific product by Product Name
	@GetMapping(value = "/product/{productName}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSpecificProductName(@PathVariable  String productName) {
		logger.info("Fetching details of product by : {}",productName);
		return productService.getSpecificProductName(productName);
	}

	// Fetch Product details of a specific product by Product Category
	@GetMapping(value = "/products/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getSpecificCategory(@PathVariable  String category) {
		logger.info("Fetching details of product by : {}",category);
		return productService.getSpecificCategory(category);
	}

	//Update Stock of Product
	@PutMapping(value = "/products/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateStock(@RequestBody Product product,@PathVariable Integer id) {
		return productService.updateStock(product,id);
		
	}
	
	//Delete Product with help of SellerID
	@DeleteMapping(value = "/product/{sellerid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer sellerid) throws Exception {
		productService.deleteProduct(sellerid);
		String successMessage = environment.getProperty("API.DELETE_PRODUCT");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	// Add Record To Subscript Product
//	@PostMapping(value = "/subscription/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> addProductToWishList(@RequestBody SubscribedproductDTO subscribedproduct) throws Exception {
		
//		BuyerDTO buyerDTO=restTemplate.getForObject(buyerUri+subscribedproduct.getBuyerid(), BuyerDTO.class);
//		if(buyerDTO.isIsprevileged()==true) {
//		  ProductDTO productDTO=productService.getSpecificProduct(subscribedproduct.getProdid());
//		  if(!productDTO.equals(null)) {
//				int buyerid = productService.addProductToSubscribedList(subscribedproduct);
//				String successMessage = environment.getProperty("API.INSERT_SUCCESS_SUBSCRIBEDLIST") + buyerid;
//				return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
//		  }else {
//				String successMessage = environment.getProperty("API.INSERT_FAILURE_PRODUCT_NOT_EXIST");
//				return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
//		  }
//		}else {
//			String successMessage = environment.getProperty("API.INSERT_FAILURE_SUBSCRIBEDLIST");
//			return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
//		}

//	}
	
	
	//Get Subscription with help of buyerid
	@GetMapping(value = "/subs/{buyerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedproductDTO> getSubscriptionByBuyerid(@PathVariable Integer buyerid) {
		logger.info("productname request for product {}", buyerid);
		return productService.getByBuyerid(buyerid);
	}
	
	
	
		//Get All Subscription Details
		@GetMapping(value = "/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<SubscribedproductDTO> getAllSubscriptionList() {
			
			List<SubscribedproductDTO>subscriptionList  =	productService.getAllSubscriptionList();
			logger.info("productname request for product {}",subscriptionList);
			return subscriptionList;
		}
		

	// Fetch product details of a specific product by Product ID
	@GetMapping(value = "/productby/{prodid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSpecificProductByID(@PathVariable  Integer prodid) throws Exception {
		logger.info("Fetching details of product by : {}",prodid);
		return productService.getSpecificProduct(prodid);
	}
}
