package com.home.totalpayImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.totalpay.TotalPayDao;
import com.home.totalpay.TotalPayVo;

@Repository("totalPayDao")
public class TotalPayDaoImpl implements TotalPayDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addtotalPay(Object userIdx, String amount) {
		Map<String, Object> map = new HashMap<>();
		map.put("amount", amount);
		map.put("userIdx", userIdx);
		sqlSession.insert("totalPay.totalPayInsert", map);
		int idx = Integer.parseInt(map.get("idx").toString());
		return idx;
	}
}
