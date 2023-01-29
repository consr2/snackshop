package com.home.snack;

import java.util.List;

public interface SnackService {

	void addSnack(SnackVo snackVo);

	List<SnackVo> showList();

}
