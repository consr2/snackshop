package com.home.snack.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.snack.SnackDao;
import com.home.snack.SnackService;
import com.home.snack.SnackVo;

@Service("snackService")
public class SnackServiceImpl implements SnackService{

	@Autowired
	private SnackDao snackDao;

	@Override
	public void addSnack(SnackVo snackVo) {
		snackDao.addSnack(snackVo);
	}

	@Override
	public List<SnackVo> showList() {
		
		return snackDao.showList();
	}
	
	
}
