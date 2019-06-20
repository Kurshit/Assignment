package com.sapient.feecalc.readerservice;

import java.util.List;

import com.sapient.feecalc.vo.Transaction;

public interface IReaderTypeService {
	
	public List<Transaction> readTransactionFile(String fileName);
	
	public void generateTransactionReport();
	
}
