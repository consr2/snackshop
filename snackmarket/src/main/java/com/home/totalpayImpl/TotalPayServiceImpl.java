package com.home.totalpayImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.totalpay.TotalPayDao;
import com.home.totalpay.TotalPayService;

@Service("totalPayService")
public class TotalPayServiceImpl implements TotalPayService {

	@Autowired
	private TotalPayDao totalPayDao;

	@Override
	public int addtotalPay(Object userIdx, String amount) {
		int payIdx = totalPayDao.addtotalPay(userIdx, amount);
		return payIdx;
	}
}
