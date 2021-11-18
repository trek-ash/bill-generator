package com.example.hackerbills.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackerbills.dto.BillDTO;
import com.example.hackerbills.exception.BillException;
import com.example.hackerbills.service.BillService;

@RestController
@RequestMapping(value = "/bills")
public class BillAPI {
	@Autowired
	private BillService billService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value="/")
	public ResponseEntity<String> addBill(@RequestBody BillDTO bill)	{
		Integer billNumber = billService.addBill(bill);
		String successMessage = environment.getProperty("BILL.CREATE_SUCCESS")+ billNumber;
		return new ResponseEntity<String>(successMessage, HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<BillDTO>> getAllBills() {
		List<BillDTO> billList = billService.getAllBills();
		return new ResponseEntity<>(billList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BillDTO> getBillDetails(@PathVariable("id") Integer id) throws BillException {
		BillDTO bill = billService.getBillDetails(id);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	

	@GetMapping(value = "/due/{date}")
	public ResponseEntity<List<BillDTO>> getBillByDate(@PathVariable("date") String date) throws BillException {
		List<BillDTO> bill = billService.getBillByDate(date);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
}
