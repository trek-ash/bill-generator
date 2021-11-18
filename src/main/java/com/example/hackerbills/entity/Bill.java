package com.example.hackerbills.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {
	@Id
	@Column(name="bill_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billNumber;
	
	@Column()
	private String billedTo;
	
	@Column()
	private String billedDate;
	
	@Column()
	private Float billAmount;
	
	public Integer getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}

	public String getBilledTo() {
		return billedTo;
	}

	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}

	public String getBilledDate() {
		return billedDate;
	}

	public void setBilledDate(String billedDate) {
		this.billedDate = billedDate;
	}

	public Float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Float billAmount) {
		this.billAmount = billAmount;
	}

	public Float getTaxOnBill() {
		return taxOnBill;
	}

	public void setTaxOnBill(Float taxOnBill) {
		this.taxOnBill = taxOnBill;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column()
	private Float taxOnBill;
	
	@Column()
	private Float totalAmount;
	
}
