package com.example.reposoitory;

import com.example.entity.Account;

public interface AccountRepository {
	public Account loadAccount(String number);
	public Account updateAccount(Account account);
}