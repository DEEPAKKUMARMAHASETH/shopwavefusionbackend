package com.shopwavefusion.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.modal.Product;
import com.shopwavefusion.request.CreateProductRequest;
import com.shopwavefusion.user.domain.ProductSubCategory;

public interface ProductService {
	
	// only for admin
	public Product createProduct(CreateProductRequest req) throws ProductException, SQLException;
	
	public String deleteProduct(Long productId) throws ProductException;
	
	public Product updateProduct(Long productId,Product product)throws ProductException;
	
	public List<Product> getAllProducts();
	
	// for user and admin both
	public Product findProductById(Long id) throws ProductException;
	
	public List<Product> findProductByCategory(String category);
	
	public List<Product> searchProduct(String query);
	
//	public List<Product> getAllProduct(List<String>colors,List<String>sizes,int minPrice, int maxPrice,int minDiscount, String category, String sort,int pageNumber, int pageSize);
	public Page<Product> getAllProduct(String category, List<String>colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount,String sort, String stock, Integer pageNumber, Integer pageSize);
	
	Page<Product> getProductsSortedByDiscountedPrice(String sortDirection, int page, int pageSize);
	Page<Product> getProductsByCategory(String categoryName, int page, int pageSize);
	Page<Product> getProductsByCategoryAndPriceRange(
            String categoryName, Integer minPrice, Integer maxPrice, int page, int pageSize);
	
	

}
