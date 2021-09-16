package com.cementapp.repository;

import java.util.List;

import com.cementapp.exception.CementNotFoundException;
import com.cementapp.model.Cement;

public interface ICementRepository {
	void addCement(Cement cement);

	void deleteCement(int cementId);

	int updateCementPrice(int cementId, double cementPrice);

	List<Cement> findAllCements();

	Cement findCementById(int cementId) throws CementNotFoundException;

	List<Cement> findCementsByBrand(String cementBrand) throws CementNotFoundException;

	List<Cement> findCementsByDistributorName(String distributorName) throws CementNotFoundException;

	List<Cement> findCementsByType(String cementType) throws CementNotFoundException;

	List<Cement> findCementsByLesserPrice(double cementPrice) throws CementNotFoundException;
}
