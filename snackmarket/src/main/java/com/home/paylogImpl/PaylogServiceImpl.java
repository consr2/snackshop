package com.home.paylogImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.paylog.PaylogDao;
import com.home.paylog.PaylogService;

@Service("paylogService")
public class PaylogServiceImpl implements PaylogService{

	@Autowired
	private PaylogDao paylogDao;

	@Override
	public void addPaylog(int payIdx, Object userIdx) {
		paylogDao.addPaylog(payIdx, userIdx);
		
	}
}
