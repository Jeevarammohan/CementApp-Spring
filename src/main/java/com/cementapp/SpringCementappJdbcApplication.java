package com.cementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cementapp.exception.CementNotFoundException;
import com.cementapp.model.Cement;
import com.cementapp.service.ICementService;

@SpringBootApplication
public class SpringCementappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCementappJdbcApplication.class, args);
	}

	@Autowired
	ICementService cementService;

	@Override
	public void run(String... args) throws Exception {
//		Cement cement = new Cement("Ambuja", "Amnoj", "PPC", 1500);
//		System.out.println("Cement Added");
//		cementService.addCement(cement);
//		cement = new Cement("Ramraj", "Pankaj", "PPC", 1590);
//		System.out.println("Cement Added");
//		cementService.addCement(cement);
		try {
			cementService.updateCementPrice(11, 1200);
			System.out.println("Updated");
		}
		catch(CementNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println("Deleted.....");
//		cementService.deleteCement(1);
		System.out.println("All Cements:..........");
		cementService.getAllCements().forEach(System.out::println);
		System.out.println("Cement by Id:");
		try {
			System.out.println(cementService.getCementById(11));
		} catch (CementNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Cements by brand:................");
		try {
			cementService.getCementsByBrand("Ambuja").forEach(System.out::println);
		} catch (CementNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Cements by distributor name:..............");
		try {
			cementService.getCementsByDistributorName("Pankaj").forEach(System.out::println);
		} catch (CementNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Cements by lesser price from given price:..................");
		try {
			cementService.getCementsByLesserPrice(5000).forEach(System.out::println);
		} catch (CementNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Cements by type:..............");
		try {
			cementService.getCementsByType("OPC").forEach(System.out::println);
		} catch (CementNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
