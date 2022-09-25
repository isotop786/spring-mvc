package com.example.demo.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@RequestMapping(value = "/{id}")
	public String displayUser(@PathVariable("id") int userId)
	{ 
		return "User found: "+userId ;
	}
	
	@RequestMapping(value="{id}/invoice", method = RequestMethod.GET)
	public String displayUserInvoices(@PathVariable long id, @RequestParam(value ="date", required =false) Date dateOrNull)
	{
		return dateOrNull == null ? String.format("Invoice of user: %d", id) : String.format("Invoice for user: %d on date : %s", id, dateOrNull);
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJSON()
	{
		String [] items = {"Shoes","glass","laptop"};
		return Arrays.asList(items);
	}
	
	@RequestMapping("/{userId}/products")
	public List<Product> displayProductJson()
	{
		List<Product> products = new ArrayList<>();
		products.add(new Product(1,"Laptop",500.62));
		products.add(new Product(2,"Glass", 20.62));
		products.add(new Product(3,"Mobile",100.62));
		products.add(new Product(4,"TV",150.90));
		
		return products;
	}
	
	
	
	
}
