package com.sapient.feecalc.readerservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sapient.feecalc.util.TransactionUtil;
import com.sapient.feecalc.vo.Transaction;
import static com.sapient.feecalc.Constants.TEN;
import static com.sapient.feecalc.Constants.FIFTY;
import static com.sapient.feecalc.Constants.FIVE_HUNDREAD;
import static com.sapient.feecalc.Constants.HUNDREAD;
import static com.sapient.feecalc.Constants.BUY;
import static com.sapient.feecalc.Constants.SELL;
import static com.sapient.feecalc.Constants.DEPOSITE;
import static com.sapient.feecalc.Constants.WITHDRAW;

public abstract class AbstractReaderType implements IReaderTypeService {

	List<Transaction> inputTransactionList = new ArrayList<>();

	List<Transaction> calculatedTransactionsList = new ArrayList<>();

	public abstract List<Transaction> readTransactionFile(String fileName);

	public Transaction calculateTransactionFee(Transaction transaction) {

		if(isIntradayTransaction(transaction)){
			transaction.setTransactionFees(TEN);
		} else {

			if(transaction.getPriority()){
				transaction.setTransactionFees(FIVE_HUNDREAD);

			} else{				
				if(transaction.getTransactionType().equals(SELL) ||
						transaction.getTransactionType().equals(WITHDRAW)){

					transaction.setTransactionFees(HUNDREAD);

				} else if(transaction.getTransactionType().equals(BUY) ||
						transaction.getTransactionType().equals(DEPOSITE)){

					transaction.setTransactionFees(FIFTY);			
				}

			}

		}

		return transaction;
	}

	private boolean isIntradayTransaction(Transaction transaction) {
		boolean isIntraDayTransaction= false;
		Transaction instraDayTransactionPair = null;
		if(inputTransactionList.size() > 0 ){

			for (Transaction trans : inputTransactionList) {
				if(trans.getClientId().equals(transaction.getClientId())&&
						trans.getSecurityId().equals(transaction.getSecurityId()) &&
						trans.getTransactionDate().equals(transaction.getTransactionDate())){
					if((trans.getTransactionType().equals(BUY) && 
							transaction.getTransactionType().equals(SELL) ||
							(trans.getTransactionType().equals(SELL) && 
									transaction.getTransactionType().equals(BUY)))){
						isIntraDayTransaction= true;
						instraDayTransactionPair= trans;						
						break;
					}
				}

			}

			if(instraDayTransactionPair!=null){
				inputTransactionList.remove(instraDayTransactionPair);
				instraDayTransactionPair.setTransactionFees(TEN);
				inputTransactionList.add(instraDayTransactionPair);
			}

		} else {
			isIntraDayTransaction= false;
		}

		return isIntraDayTransaction;
	}

	public Transaction getTransaction(String[] transactionAttributes) {	
		Transaction transaction = new Transaction();
		transaction.setExternalTransactionID(transactionAttributes[0]);
		transaction.setClientId(transactionAttributes[1]);
		transaction.setSecurityId(transactionAttributes[2]);
		transaction.setTransactionType(String.valueOf(transactionAttributes[3]));
		transaction.setTransactionDate(TransactionUtil.parseDate(transactionAttributes[4]));
		transaction.setMarketValue(Double.valueOf(transactionAttributes[5]));
		transaction.setPriority(TransactionUtil.getPriority(transactionAttributes[6]));
		return transaction;
	}


	public void generateTransactionReport(){
		Collections.sort(inputTransactionList,new Transaction());
		for (Transaction transaction : inputTransactionList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(transaction.getClientId()+"\t| "+transaction.getTransactionType()+"\t| "+
					transaction.getTransactionDate()+"\t| "+ transaction.getPriority()+ "\t| "+
					transaction.getTransactionFees()+"\t|");
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

}
