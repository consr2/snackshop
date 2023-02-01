package com.home.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface UserDao {

	UserVo loginProcess(HashMap<String, Object> map);

	void singUp(HashMap<String, Object> map);

	void singUpNaver(Map<String, Object> map);

}
