package com.home.tosspay;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.basket.BasketService;
import com.home.paylog.PaylogService;
import com.home.totalpay.TotalPayService;

@Controller
public class TossPayController {

	@Autowired
	private TotalPayService totalPayService;
	@Autowired
	private PaylogService paylogService;
	@Autowired
	private BasketService basketService;
	
	@RequestMapping("/tosspay/success")
	public String processPayments(@RequestParam("orderId")String orderId
			,@RequestParam("paymentKey")String paymentKey, @RequestParam("amount")String amount
			,HttpSession session) {
		TossPay tossPay = new TossPay();
		//토스 결제 승인하기
		String result = tossPay.tossPaySuccessApi(paymentKey, orderId, amount);
		
		Object userIdx = session.getAttribute("userIdx");
		//DB에 총 결제금액 저장
		int payIdx = totalPayService.addtotalPay(userIdx, amount);
		//세부목록 저장, 장바구니 비우기
		paylogService.addPaylog(payIdx, userIdx);
		//장바구니 비우기
		basketService.userDelete(userIdx);
		
		System.out.println("toss: " + result);
		return "redirect:/";
	}
	
}
