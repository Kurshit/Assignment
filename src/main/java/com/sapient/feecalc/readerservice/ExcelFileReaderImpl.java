package com.sapient.feecalc.readerservice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import com.sapient.feecalc.util.TransactionUtil;
import com.sapient.feecalc.vo.Transaction;


public class ExcelFileReaderImpl extends AbstractReaderType {

	@Value("${separator}")
	String separator;

	@Override
	public List<Transaction> readTransactionFile(String fileName) {

		System.out.println("Excel Type Implementation >>>>");

		FileInputStream excelFile = null;
		Workbook workbook = null;
		XSSFSheet transactionSheet = null;
		try {

			excelFile = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(excelFile);
			transactionSheet = (XSSFSheet) workbook.getSheetAt(0);
			Iterator<Row> iterator = transactionSheet.iterator();
			int rowIndex = 0;

			while (iterator.hasNext()) {
				Transaction transaction = new Transaction();
				Row row = iterator.next();
				if(rowIndex > 0) {
					Iterator<Cell> cellIterator = row.iterator();
					
					transaction.setExternalTransactionID(String.valueOf(cellIterator.next()));
					transaction.setClientId(String.valueOf(cellIterator.next()));
					transaction.setSecurityId(String.valueOf(cellIterator.next()));
					transaction.setTransactionType(String.valueOf(cellIterator.next()));
					DataFormatter formatter = new DataFormatter();
					transaction.setTransactionDate(TransactionUtil.parseDate(formatter.formatCellValue(cellIterator.next())));
					transaction.setMarketValue(Double.valueOf(String.valueOf(cellIterator.next())));
					transaction.setPriority(TransactionUtil.getPriority(String.valueOf(cellIterator.next())));
					inputTransactionList.add(calculateTransactionFee(transaction));

				}			

				rowIndex++;

			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return inputTransactionList;

	}



}
