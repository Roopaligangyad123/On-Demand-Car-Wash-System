package com.cg.service;

import java.util.List;

import com.cg.models.Payment;

public interface PaymentService 
{
	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment getPaymentById(String transactionId);
}
