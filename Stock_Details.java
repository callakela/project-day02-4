package com.example.demo1;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Stock_Details")
public class Stock_Details {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	@NotNull
	private int id;
	@Column(name = "companyName")
 	String companyName;
	@Column(name = "stcokVlaue")
	 double stcokVlaue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getStcokVlaue() {
		return stcokVlaue;
	}
	public void setStcokVlaue(double stcokVlaue) {
		this.stcokVlaue = stcokVlaue;
	}

}
