package com.home.naver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NaverLoginBO {
	
	//인증 요청문을 구성하는 파라미터
	private String CLIENT_ID = "eE1CQqaXgF_JST8T1Z12";
	private String CLIENT_SECRET = "oc4QksT_0T";
	private String redirect_uri = "http://localhost:8080/login/napi";
	private SecureRandom random = new SecureRandom();
	private String state = new BigInteger(130, random).toString();
	private String access_token = "";
	
	private String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
			+ "&client_id=" 	+ CLIENT_ID
			+ "&redirect_uri=" 	+ redirect_uri
			+ "&state=" 		+ state;
	
	
	//토큰 얻기
	public String getToken(String code, String state) {
		
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
				+ "&client_id="		+ CLIENT_ID
				+ "&client_secret=" + CLIENT_SECRET
				+ "&redirect_uri=" + redirect_uri
				+ "&code=" + code
				+ "&state=" + state;
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			
			String res = "";
			if(responseCode == 200) {
				res = readBody(con.getInputStream());
				System.out.println("토큰 발급 : " + res);
				HashMap<String, Object> map = new ObjectMapper().readValue(res, HashMap.class);
				access_token = map.get("access_token").toString();
			}else {
				res = readBody(con.getInputStream());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return access_token;
	}
	
	//토큰 만료시키기
	public String deleteToken(String token) {
		
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete"
				+ "&client_id="		+ CLIENT_ID
				+ "&client_secret=" + CLIENT_SECRET
				+ "&access_token=" + token
				+ "&service_provider=NAVER";
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			
			String res = "";
			if(responseCode == 200) {
				res = readBody(con.getInputStream());
			}else {
				res = readBody(con.getInputStream());
			}
			
			System.out.println("토큰 삭제 : " + res);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "1";
	}
	
	public String getUserInfo(String token) {
		String header = "Bearer " + token;
		
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			for(Map.Entry<String, String> head :requestHeaders.entrySet()) {
				con.setRequestProperty(head.getKey(), head.getValue());
			}
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			}else {
				return readBody(con.getErrorStream());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "1";
	}
	
	//api response 받는 메서드
	public String readBody(InputStream body) {
		String rs = "";
		
		InputStreamReader streamReader = new InputStreamReader(body);
		
		try(BufferedReader br = new BufferedReader(streamReader)){
			StringBuilder responseBody = new StringBuilder();
			
			String line;
			while((line = br.readLine()) != null) {
				responseBody.append(line);
			}
			
			rs = responseBody.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//Getter, Setter
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}

	public String getCLIENT_SECRET() {
		return CLIENT_SECRET;
	}

	public void setCLIENT_SECRET(String cLIENT_SECRET) {
		CLIENT_SECRET = cLIENT_SECRET;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public SecureRandom getRandom() {
		return random;
	}

	public void setRandom(SecureRandom random) {
		this.random = random;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}
	
	
}
