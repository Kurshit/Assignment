package com.sapient.feecalc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sapient.feecalc.readerservice.AbstractReaderType;
import com.sapient.feecalc.readerservice.CSVFileReaderImpl;
import com.sapient.feecalc.readerservice.ExcelFileReaderImpl;
import com.sapient.feecalc.readerservice.TextFileReaderImpl;

@Configuration
public class ReaderTypeConfig {	
	@Value("${filetype}")
	String fileType;
	
	@Bean
	AbstractReaderType readerType() {
		switch(fileType) {
			case "txt" : return new TextFileReaderImpl();
			case "csv" : return new CSVFileReaderImpl();
			case "excel" : return new ExcelFileReaderImpl();						
		}
		return null;
	}
	
}
