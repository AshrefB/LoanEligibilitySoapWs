package com.ashref.loan.soap.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ashref.loan.soap.ws.loaneligibility.CustomerRequest;
import com.ashref.loan.soap.ws.loaneligibility.WsResponse;
import com.ashref.loan.soap.ws.services.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndPoint {
	private final String NAMESPACE = "http://www.ashref.com/loan/soap/ws/loanEligibility";
	@Autowired
	private LoanEligibilityService service;
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	public WsResponse getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
}
