package com.cementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cementapp.exception.CementNotFoundException;
import com.cementapp.model.Cement;
import com.cementapp.repository.ICementRepository;

@Service
public class CementServiceImpl implements ICementService {

	@Autowired
	ICementRepository cementRepository;

	@Override
	public void addCement(Cement cement) {
		cementRepository.addCement(cement);
	}

	@Override
	public void deleteCement(int cementId) {
		cementRepository.deleteCement(cementId);
	}

	@Override
	public void updateCementPrice(int cementId, double cementPrice) {
		int rowChanged = cementRepository.updateCementPrice(cementId, cementPrice);
		if(rowChanged==0) {
			throw new CementNotFoundException("Not Updated...Invalid Id");
		}
	}

	@Override
	public List<Cement> getAllCements() {
		return cementRepository.findAllCements();
	}

	@Override
	public Cement getCementById(int cementId) throws CementNotFoundException {
		
		Cement cement = null;
		try{
			cement = cementRepository.findCementById(cementId);
		}catch(Exception e) {
			throw new CementNotFoundException("invalid Id");
		}
		return cement;
	}

	@Override
	public List<Cement> getCementsByBrand(String cementBrand) throws CementNotFoundException {
		List<Cement> cementList = cementRepository.findCementsByBrand(cementBrand);
		if (cementList.isEmpty()) {
			throw new CementNotFoundException("Brand not found");
		}
		return cementList;
	}

	@Override
	public List<Cement> getCementsByDistributorName(String distributorName) throws CementNotFoundException {

		List<Cement> cementList = cementRepository.findCementsByDistributorName(distributorName);
		if (cementList.isEmpty()) {
			throw new CementNotFoundException("Distributor Name not found");
		}
		return cementList;
	}

	@Override
	public List<Cement> getCementsByType(String cementType) throws CementNotFoundException {
		List<Cement> cementList = cementRepository.findCementsByType(cementType);
		if (cementList.isEmpty()) {
			throw new CementNotFoundException("Type not found");
		}
		return cementList;
	}

	@Override
	public List<Cement> getCementsByLesserPrice(double cementPrice) throws CementNotFoundException {
		List<Cement> cementList = cementRepository.findCementsByLesserPrice(cementPrice);
		if (cementList.isEmpty()) {
			throw new CementNotFoundException("Cement not found for price less than the given price");
		}
		return cementList;
	}

}
