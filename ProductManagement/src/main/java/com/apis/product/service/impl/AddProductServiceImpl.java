package com.apis.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.product.dao.IAddProductDao;
import com.apis.product.service.AddProductService;
import com.beans.CommonResponseBean;
import com.beans.ProductBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.ProductMaster;

@Service
public class AddProductServiceImpl implements AddProductService {
	@Autowired
	private IAddProductDao addProductDao;

	@Override
	public String addProduct(ProductBean requestBean) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ProductMaster productMaster = mapper.convertValue(requestBean, ProductMaster.class);
			String response = addProductDao.addProduct(productMaster);
			return response;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR100"));
		}
	}

	@Override
	public List<ProductMaster> fetchProduct() {
		try {
			List<ProductMaster> productList = addProductDao.fetchProduct();
			return productList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ProductMaster fetchProductById(Long productId) {
		try {
			ProductMaster product = addProductDao.fetchProductById(productId);
			return product;
		} catch (Exception e) {
			return null;
		}

	}
}
