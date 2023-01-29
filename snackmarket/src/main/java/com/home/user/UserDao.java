package com.home.user;

import java.util.HashMap;
import java.util.Optional;

public interface UserDao {

	UserVo loginProcess(HashMap<String, Object> map);

	void singUp(HashMap<String, Object> map);

}
