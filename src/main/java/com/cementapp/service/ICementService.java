package com.cementapp.service;

import java.util.List;

import com.cementapp.exception.CementNotFoundException;
import com.cementapp.model.Cement;

public interface ICementService {
	void addCement(Cement cement);

	void deleteCement(int cementId);

	void updateCementPrice(int cementId, double cementPrice);

	List<Cement> getAllCements();

	Cement getCementById(int cementId) throws CementNotFoundException;

	List<Cement> getCementsByBrand(String cementBrand) throws CementNotFoundException;

	List<Cement> getCementsByDistributorName(String distributorName) throws CementNotFoundException;

	List<Cement> getCementsByType(String cementType) throws CementNotFoundException;

	List<Cement> getCementsByLesserPrice(double cementPrice) throws CementNotFoundException;

}
