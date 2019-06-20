package com.sapient.feecalc.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionUtil {
	
	public static Boolean getPriority(String priority) {
		if(priority!= null){
			priority = priority.trim();
			if(priority.equals("Y")||priority.equals("y")){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	public static Date parseDate(String date) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date convertedCurrentDate = sdf.parse(date);
			return convertedCurrentDate;
		}catch(Exception  ex){
			return null;
		}
	}
}
