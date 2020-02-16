package com.ashref.loan.soap.ws.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashref.loan.soap.ws.loaneligibility.CustomerRequest;
import com.ashref.loan.soap.ws.loaneligibility.WsResponse;

@Service
public class LoanEligibilityService {

	public WsResponse checkLoanEligibility(CustomerRequest request) {
		WsResponse response = new WsResponse();
		List<String> criteriaMismatch = response.getCriteriaMismatch();

		if (!(request.getAge() >= 30 && request.getAge() <= 50))
			criteriaMismatch.add("Client age must be between 30 and 50");

		if (!(request.getYearlyIncome() > 20000))
			criteriaMismatch.add("Client minimum yearly income must be over 20000");

		if (!(request.getCibilScore() > 500))
			criteriaMismatch.add("Client cibil score must be over 500");

		if (criteriaMismatch.size() > 0) {
			response.setApprovedAmount(0);
			response.setIsEligible(false);
		} else {
			response.setApprovedAmount(1500);
			response.setIsEligible(true);
			criteriaMismatch.clear();
		}

		return response;
	}
}
