package com.sapient.feecalc.readerservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;

import com.sapient.feecalc.vo.Transaction;


public class TextFileReaderImpl extends AbstractReaderType {

	@Value("${separator}")
	String separator;

	@Override
	public List<Transaction> readTransactionFile(String fileName) {
		System.out.println("txt Type Implementation >>>>");
		Stream<String> streams = null;
		try {
			streams = Files.lines(Paths.get(fileName));
			streams.forEach( line -> {
				String[] transactionAttributes = line.split(separator);
				Transaction transaction = getTransaction(transactionAttributes); 
				inputTransactionList.add(calculateTransactionFee(transaction));

			});

		} catch(FileNotFoundException exception)
		{
			System.out.println("File does not exist");
			exception.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if(streams != null)
				streams.close();
		}

		return inputTransactionList;


	}



}
