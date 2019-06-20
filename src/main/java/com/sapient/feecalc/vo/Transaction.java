package com.sapient.feecalc.vo;

import java.util.Comparator;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction implements Comparator<Transaction> {
	
	private String externalTransactionID;
    private String clientId;
    private String securityId;
    private String transactionType;
    private java.util.Date transactionDate;
    private Double marketValue;
    
    public String getExternalTransactionID() {
		return externalTransactionID;
	}
	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public java.util.Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	public Boolean getPriority() {
		return priority;
	}
	public void setPriority(Boolean priority) {
		this.priority = priority;
	}
	public Long getTransactionFees() {
		return transactionFees;
	}
	public void setTransactionFees(Long transactionFees) {
		this.transactionFees = transactionFees;
	}
	private Boolean priority;
    private Long transactionFees;

    @Override
	public int compare(Transaction ob1, Transaction ob2) {
		
		int value1 = ob1.getClientId().compareTo(ob2.getClientId());
		if (value1 == 0) {
			int value2 = ob1.getTransactionType().compareTo(ob2.getTransactionType());
			if (value2 == 0) {
				int value3 = ob1.getTransactionDate().compareTo(ob2.getTransactionDate());
				if (value3 == 0) {
					return ob1.getPriority().compareTo(ob2.getPriority());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;

	}

}
