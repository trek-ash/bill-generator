package com.example.hackerbills.dto;

import java.util.Date;

public class BillDTO {
	private Integer billNumber;
	

	private String billedTo;
	

	private String billedDate;
	

	private Float billAmount;
	
	public BillDTO(Integer billNumber, String billedTo, String billedDate, Float billAmount, Float taxOnBill,
			Float totalAmount) {
		super();
		this.billNumber = billNumber;
		this.billedTo = billedTo;
		this.billedDate = billedDate;
		this.billAmount = billAmount;
		this.taxOnBill = taxOnBill;
		this.totalAmount = totalAmount;
	}

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

	private Float taxOnBill;
	

	private Float totalAmount;
}
