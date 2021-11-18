package com.example.hackerbills.service;

import java.util.List;

import com.example.hackerbills.dto.BillDTO;
import com.example.hackerbills.exception.BillException;

public interface BillService {

	Integer addBill(BillDTO bill);

	List<BillDTO> getAllBills();

	BillDTO getBillDetails(Integer id) throws BillException;

	List<BillDTO> getBillByDate(String date) throws BillException;

}
