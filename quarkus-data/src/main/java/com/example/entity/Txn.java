package com.example.entity;

import java.time.LocalDate;
import java.util.Date;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Txn  extends PanacheMongoEntity{

	private int id;
	private double amount;
	private LocalDate date;
	private TxnType txnType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TxnType getTxnType() {
		return txnType;
	}

	public void setTxnType(TxnType txnType) {
		this.txnType = txnType;
	}

}
