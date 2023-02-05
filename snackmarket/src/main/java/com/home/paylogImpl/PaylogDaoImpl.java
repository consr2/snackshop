package com.home.paylogImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.basket.BasketAndSnackVo;
import com.home.basket.BasketVo;
import com.home.paylog.PaylogDao;

@Repository("paylogDao")
public class PaylogDaoImpl implements PaylogDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addPaylog(int payIdx, Object userIdx) {
		List<BasketVo> basketList = sqlSession.selectList("Basket.basketList", userIdx);
		Map<String, Object> map = new HashMap<>();
		map.put("payIdx", payIdx);
		map.put("list", basketList);
		//결제 과자 목록 추가
		sqlSession.insert("paylog.paylogInsert", map);
	}
}
