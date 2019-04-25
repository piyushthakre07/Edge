package com.apis.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.product.service.AddProductService;
import com.beans.CommonResponseBean;
import com.beans.ProductBean;
import com.beans.ProductListBean;
import com.google.gson.Gson;
import com.model.ProductMaster;

/**
 * @author piyusht4
 * @since 17-04-2018
 */
@RestController
public class AddProductController {
	@Autowired
	AddProductService addProductService;

	/**
	 * @param requestBean
	 * @return String in Json format
	 */
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public @ResponseBody String addProduct(@RequestBody ProductBean requestBean) {
		String response = addProductService.addProduct(requestBean);
		return response;
	}

	/**
	 * @return String in Json format
	 */
	@GetMapping(value = "/fetchallproduct")
	public @ResponseBody String fetchAllProduct() {
		try {
			List<ProductMaster> listProduct = addProductService.fetchProduct();
			if (listProduct != null) {
				ProductListBean productListBean = new ProductListBean();
				productListBean.setProductList(listProduct);
				return new Gson().toJson(productListBean);
			} else {
				return new Gson().toJson(new CommonResponseBean("No Record Found", "1", ""));
			}
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "Error001"));
		}
	}

	/**
	 * @param productId
	 * @return String in Json format
	 */
	@RequestMapping(value = "/fetchbyproductid/{productId}")
	public @ResponseBody String frtchProductById(@PathVariable("productId") int productId) {
		try {
			ProductMaster product = addProductService.fetchProductById(new Long(productId));
			if (product != null) {
				return new Gson().toJson(product);
			} else {
				return new Gson().toJson(new CommonResponseBean("No Record Found", "1", ""));
			}
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "Error001"));
		}
	}
}
