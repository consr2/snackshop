package com.home.tosspay;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TossPay {

	public String tossPaySuccessApi(String paymentKey, String orderId, String amount) {
		String resulte = "";
		try {
			HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
			    .header("Authorization", "Basic dGVzdF9za19qWjYxSk94UlFWRTFsak83S216VlcwWDliQXF3Og==")
			    .header("Content-Type", "application/json")
			    .method("POST", HttpRequest.BodyPublishers.ofString("{\"paymentKey\":\"" + paymentKey + "\",\"amount\":" + amount + ",\"orderId\":\"" + orderId + "\"}"))
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			resulte = response.body().toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resulte;
	}
}
