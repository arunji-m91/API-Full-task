package com.payload.product;

import com.pojo.product.ProductSearch_Input_Pojo;

public class ProductSearchPayload {

	public ProductSearch_Input_Pojo searchProduct(String text) {

		ProductSearch_Input_Pojo productSearch_Input_Pojo = new ProductSearch_Input_Pojo(text);
		return productSearch_Input_Pojo;

	}

}
