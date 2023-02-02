package com.home.tosspay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TossPayController {

	@RequestMapping("/tosspay/success")
	public String processPayments(@RequestParam("orderId")String orderId
			,@RequestParam("paymentKey")String paymentKey, @RequestParam("amount")String amount) {
		TossPay tossPay = new TossPay();
		String result = tossPay.tossPaySuccessApi(paymentKey, orderId, amount);
		System.out.println("toss: " + result);
		return "redirect:/";
	}
}
