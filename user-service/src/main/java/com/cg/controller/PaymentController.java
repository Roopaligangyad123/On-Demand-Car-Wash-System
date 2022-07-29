package com.cg.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Payment;
import com.cg.service.PaymentService;


@CrossOrigin("origins = \"http://localhost:3000\"")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	transient private PaymentService paymentService;

	@GetMapping("/all")
	public List<Payment> fetchAllPayments() {

		List<Payment> payments = paymentService.getAllPayments();
		return payments;
	}

	@PostMapping("/save")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {

		Payment newPayment = paymentService.savePayment(payment);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchPaymentById(@PathVariable("id") String paymentId) {

		ResponseEntity<?> responseEntity = null;
		Payment payment = paymentService.getPaymentById(paymentId);
		responseEntity = new ResponseEntity<>(payment, HttpStatus.OK);
		return responseEntity;
	}

}