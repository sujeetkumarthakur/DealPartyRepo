package com.bs.login;

import java.util.List;

public interface LoginServiceI {
	public LoginDetails createLoginDetails(LoginDetails loginDetail);

	public LoginDetails updateLoginDetails(LoginDetails loginDetail);

	public String deleteLoginDetails(int id);

	public List<LoginDetails> getLoginDetails();	
	
	public boolean isLogined(LoginDetails loginDetail);
	public LoginDetails getToken(int loginId);

}
