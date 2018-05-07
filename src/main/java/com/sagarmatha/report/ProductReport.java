package com.sagarmatha.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sagarmatha.domain.DemoProduct;
import com.sagarmatha.domain.ProductModal;

public class ProductReport {
	
	public List<Map<String, ?>> findAll(){
		
		List<Map<String, ?>> listProducts = new ArrayList<Map<String,?>>();
		ProductModal productModal = new ProductModal();
		for(DemoProduct p : productModal.findAll()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Id", p.getId());
			m.put("Name", p.getName());
			m.put("Category", p.getCategory());
			m.put("Quantity", p.getQuantity());
			listProducts.add(m);
		}
		return listProducts;

		
	}

}
