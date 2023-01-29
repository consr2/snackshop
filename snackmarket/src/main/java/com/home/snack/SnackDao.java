package com.home.snack;

import java.util.List;

public interface SnackDao {

	void addSnack(SnackVo snackVo);

	List<SnackVo> showList();

}
