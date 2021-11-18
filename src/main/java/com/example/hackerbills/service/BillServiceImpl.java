package com.example.hackerbills.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackerbills.dto.BillDTO;
import com.example.hackerbills.entity.Bill;
import com.example.hackerbills.exception.BillException;
import com.example.hackerbills.repository.BillRepository;

@Service(value="billService")
@Transactional
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Integer addBill(BillDTO bill) {
		Bill billEntity = new Bill();
		billEntity.setBillAmount(bill.getBillAmount());
		billEntity.setBilledDate(bill.getBilledDate());
		billEntity.setBilledTo(bill.getBilledTo());
		billEntity.setTaxOnBill(bill.getTaxOnBill());
		billEntity.setTotalAmount(bill.getTotalAmount());
		Bill savedBill = billRepository.save(billEntity);
		return savedBill.getBillNumber();
	}
	
	@Override
	public List<BillDTO> getAllBills()  {
		Iterable<Bill> bills = billRepository.findAll();
		List<BillDTO> billsDTO = new ArrayList();
		bills.forEach(
						bill->{
							BillDTO billDTO = new BillDTO(bill.getBillNumber(), bill.getBilledTo(), bill.getBilledDate(), bill.getBillAmount(), bill.getTaxOnBill(), bill.getTotalAmount());
							billsDTO.add(billDTO);							
						});
		
		return billsDTO;
	}
	
	@Override
	public BillDTO getBillDetails(Integer id) throws BillException	{
		Optional<Bill> billOptional = billRepository.findById(id);
		BillDTO billDetail = null;
		if(!billOptional.isPresent())	{
			throw new BillException("BillService.NO_BILL");
		}else	{
			Bill bill = billOptional.get();	
			billDetail = new BillDTO(bill.getBillNumber(), bill.getBilledTo(), bill.getBilledDate(), bill.getBillAmount(), bill.getTaxOnBill(), bill.getTotalAmount());
		}
		
		return billDetail;
		
	}
	
	@Override
	public List<BillDTO> getBillByDate(String date) throws BillException	{
		Iterable<Bill> bills = billRepository.findAllByBilledDate(date);
		List<BillDTO> billsDTO = new ArrayList();
		bills.forEach(
						bill->{
							BillDTO billDTO = new BillDTO(bill.getBillNumber(), bill.getBilledTo(), bill.getBilledDate(), bill.getBillAmount(), bill.getTaxOnBill(), bill.getTotalAmount());
							billsDTO.add(billDTO);							
						});
		
		return billsDTO;
		
	}
}
