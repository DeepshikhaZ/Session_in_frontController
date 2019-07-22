package com.lti.services;



import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lti.dao.ProductDAO;
import com.lti.entities.Product;

@Path("products")
public class ProductService {
	private ProductDAO dao = new ProductDAO();
//  http://localhost:8080/ProductCatalog/api/products
@GET @Produces("application/json")
public Map findAll() {
	return dao.getAll();
}

// http://localhost:8080/ProductCatalog/api/products/by?id=101
@GET  @Path("by") @Produces("application/json")
public Product find(@QueryParam("id") int id) {
	return dao.findById(id);
  }
}
