package com.bs.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginServiceI {
	@Autowired
	private LoginRepo repo;

	@Override
	public LoginDetails createLoginDetails(LoginDetails loginDetail) {
		loginDetail.setToken(getAlphaNumericString());
		return repo.save(loginDetail);
	}

	@Override
	public LoginDetails updateLoginDetails(LoginDetails loginDetail) {
		LoginDetails obj = null;
		Optional<LoginDetails> existed = repo.findById(loginDetail.getLoginId());
		if (existed.isPresent()) {
			obj = existed.get();
			obj.setDeal(loginDetail.getDeal());
			obj.setPassword(loginDetail.getPassword());
//			obj.setToken(loginDetail.getToken());
			obj.setUsername(loginDetail.getUsername());
			repo.save(obj);
		}
		return obj;
	}

	@Override
	public String deleteLoginDetails(int id) {

		return null;
	}

	@Override
	public boolean isLogined(LoginDetails loginDetail) {
		List<LoginDetails> all = getLoginDetails();
		boolean flag=false;
		for(LoginDetails obj:all) {
			if (obj.getUsername().equals(loginDetail.getUsername())
					&& obj.getPassword().equals(loginDetail.getPassword()))
				flag=true; 
			break;
		}
		return flag;
	}

	@Override
	public List<LoginDetails> getLoginDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public LoginDetails getToken(int loginId) {
		Optional<LoginDetails> existed = repo.findById(loginId);
		LoginDetails obj = null;
		if (existed.isPresent()) {
			obj = existed.get();
			if (obj.getToken() == "" || obj.getToken() == null)
				obj.setToken(getAlphaNumericString());
			return obj;
		} else
			return null;
	}

	static String getAlphaNumericString() {
		int n = 10;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
