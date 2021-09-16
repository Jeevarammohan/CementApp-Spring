package com.cementapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cement {
	private Integer cementId;
	private String cementBrand;
	private String distributorName;
	private String cementType;
	private double cementPrice;

	public Cement(String cementBrand, String distributorName, String cementType, double cementPrice) {
		super();
		this.cementBrand = cementBrand;
		this.distributorName = distributorName;
		this.cementType = cementType;
		this.cementPrice = cementPrice;
	}

}
