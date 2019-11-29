package com.bankapp.web.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransferBean {
	@NotNull(message="from account can not be lelf blank")
	private Long fromAccount;
	
	@NotNull(message="to account not be lelf blank")
	private Long toAccount;
	
	@NotNull(message="amount can not be lelf blank")
	@Max(message="value should be less then 200000", value=200000)
	@Min(message="value should be more then 500", value=500)
	private Double amount;
	
	
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
