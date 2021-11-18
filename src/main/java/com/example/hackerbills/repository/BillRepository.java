package com.example.hackerbills.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hackerbills.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer>{
	public List<Bill> findAllByBilledDate(String date);
}
