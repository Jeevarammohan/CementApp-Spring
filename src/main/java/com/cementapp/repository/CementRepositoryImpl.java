package com.cementapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cementapp.exception.CementNotFoundException;
import com.cementapp.model.Cement;

@Repository
public class CementRepositoryImpl implements ICementRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addCement(Cement cement) {
		String insertQuery = "INSERT INTO cement(cementBrand,distributorName,cementType,cementPrice) VALUES(?,?,?,?)";
		Object[] objectArray = { cement.getCementBrand(), cement.getDistributorName(), cement.getCementType(),
				cement.getCementPrice() };
		jdbcTemplate.update(insertQuery, objectArray);
	}

	@Override
	public void deleteCement(int cementId) {
		String deleteQuery = "DELETE FROM cement WHERE cementId=?";
		Object[] objectArray = { cementId };
		jdbcTemplate.update(deleteQuery, objectArray);
	}

	@Override
	public int updateCementPrice(int cementId, double cementPrice) {
		String updateQuery = "UPDATE cement SET cementPrice=? WHERE cementId=?";
		Object[] objectArray = { cementPrice, cementId };
		return jdbcTemplate.update(updateQuery, objectArray);
	}

	@Override
	public List<Cement> findAllCements() {
		String sqlQuery = "SELECT * FROM cement";
		List<Cement> cementList = jdbcTemplate.query(sqlQuery, new CementMapper());
		return cementList;
	}

	@Override
	public Cement findCementById(int cementId) throws CementNotFoundException {
		String sqlQuery = "SELECT * FROM cement WHERE cementId=?";
		return jdbcTemplate.queryForObject(sqlQuery, new CementMapper(), cementId);
	}

	@Override
	public List<Cement> findCementsByBrand(String cementBrand) throws CementNotFoundException {
		String sqlQuery = "SELECT * FROM cement WHERE cementBrand=?";
		return jdbcTemplate.query(sqlQuery, new CementMapper(), cementBrand);
	}

	@Override
	public List<Cement> findCementsByDistributorName(String distributorName) throws CementNotFoundException {
		String sqlQuery = "SELECT * FROM cement WHERE distributorName=?";
		return jdbcTemplate.query(sqlQuery, new CementMapper(), distributorName);
	}

	@Override
	public List<Cement> findCementsByType(String cementType) throws CementNotFoundException {
		String sqlQuery = "SELECT * FROM cement WHERE cementType=?";
		return jdbcTemplate.query(sqlQuery, new CementMapper(), cementType);
	}

	@Override
	public List<Cement> findCementsByLesserPrice(double cementPrice) throws CementNotFoundException {
		String sqlQuery = "SELECT * FROM cement WHERE cementPrice<?";
		return jdbcTemplate.query(sqlQuery, new CementMapper(), cementPrice);
	}

}
