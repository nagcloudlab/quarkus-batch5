package com.example.web;

public class TxrRequest {

	private double amount;
	private String fromAccNumber;
	private String toAccNumber;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromAccNumber() {
		return fromAccNumber;
	}

	public void setFromAccNumber(String fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}

	public String getToAccNumber() {
		return toAccNumber;
	}

	public void setToAccNumber(String toAccNumber) {
		this.toAccNumber = toAccNumber;
	}

}
