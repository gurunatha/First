package org.gurutech.first;

public class Account {
	
	int balance;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void details(String name)
	{
		System.out.println("welcome to your a/c: "+name+" :: Available balance ::"+balance);
	}

}
