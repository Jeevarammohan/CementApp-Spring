package com.cementapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cementapp.model.Cement;

public class CementMapper implements RowMapper<Cement> {

	@Override
	public Cement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cement cement = new Cement();
		cement.setCementId(rs.getInt("cementId"));
		cement.setCementBrand(rs.getString("cementBrand"));
		cement.setDistributorName(rs.getString("distributorName"));
		cement.setCementType(rs.getString("cementType"));
		cement.setCementPrice(rs.getDouble("cementPrice"));
		return cement;
	}

}
