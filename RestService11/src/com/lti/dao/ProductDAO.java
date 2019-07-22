package com.lti.dao;

import java.util.HashMap;
import java.util.Map;

import com.lti.entities.Product;

public class ProductDAO {
		private Map<Integer,Product> products = new HashMap<>();

		public ProductDAO() {
			products.put(101,new Product("Iron Man Toy-Set", "New Iron Man Collection (Inifinity War)",2300));
			products.put(102,new Product("Captain America Shield", "A Shield made in plastic for age group below 13",200));
		}

		public Product findById(int id) {
			return products.get(id);
		}

		public Map<Integer,Product> getAll(){
			return products;
		    }
		}

