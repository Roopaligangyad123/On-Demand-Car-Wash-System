package com.cg.models;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {

	@Id
	private String transactionId;

	@NotNull
	@Size(min=16,max=16,message="Card Number should of 16 digits")
	private String cardNumber;

	@NotNull(message = "Card type should not be empty")
	private String cardType;

	@NotNull(message = "Bank name should not be empty")
	private String bankName;

	@NotNull(message = "Amount should not be empty")
	private double amount;

	private String description;

	@NotNull(message = "Payment Date should not be empty")
	private String paymentDate;

	@NotNull(message = "User Id should not be empty")
	private int id;

	@NotNull(message = "Packagename name should not be empty")
	private String packagename;

	public Payment() {

	}

	public Payment(String transactionId,
			@NotNull(message = "Card number should not be empty") @Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$", message = " string should be starts with 4") String cardNumber,
			@NotNull(message = "Card type should not be empty") String cardType,
			@NotNull(message = "Bank name should not be empty") String bankName,
			@NotNull(message = "Amount should not be empty") double amount, String description,
			@NotNull(message = "Payment Date should not be empty") String paymentDate,
			@NotNull(message = "User Id should not be empty") int id,
			@NotNull(message = "Packagename name should not be empty") String packagename) {
		super();
		this.transactionId = transactionId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.bankName = bankName;
		this.amount = amount;
		this.description = description;
		this.paymentDate = paymentDate;
		this.id = id;
		this.packagename = packagename;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", bankName=" + bankName + ", amount=" + amount + ", description=" + description + ", paymentDate="
				+ paymentDate + ", id=" + id + ", packagename=" + packagename + "]";
	}

	
}