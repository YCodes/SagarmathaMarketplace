package com.sagarmatha.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductModal {

	public List<DemoProduct> findAll(){
		List<DemoProduct> listProducts = new ArrayList<DemoProduct>();
		listProducts.add(new DemoProduct(45,"AcerBook","Laptop",10));
		listProducts.add(new DemoProduct(46,"AcerBook Pro","Laptop",20));
		listProducts.add(new DemoProduct(47,"AcerBook Air","Ultrabook",30));
		
		return listProducts;
	}
}
