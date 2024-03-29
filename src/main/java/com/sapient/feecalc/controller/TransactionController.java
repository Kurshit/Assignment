package com.sapient.feecalc.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.feecalc.readerservice.AbstractReaderType;

@RestController
public class TransactionController {
	
	@Autowired
	AbstractReaderType service;
	
	@RequestMapping("/generatereport/{filename}")
	public void displayReport(@PathVariable("filename") String fileName) throws IOException {
	
		service.readTransactionFile(fileName);
		System.out.println("The Calculated Fees:");
		System.out.println("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |");
		service.generateTransactionReport();
		
	}

}
