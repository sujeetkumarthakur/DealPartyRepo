package com.bs.login;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bs.deal.Deal;

@Entity
@Table
public class LoginDetails {
	@Id
	@Column(name = "loginId")
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private int loginId;
	private String username;
	private String password;
	private String token;

	@OneToOne(targetEntity = Deal.class,cascade  = CascadeType.ALL,mappedBy = "loginDetails")
	private Deal deal;

	public LoginDetails(int loginId, String username, String password, String token, Deal deal) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.token = token;
		this.deal = deal;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginDetails() {
		super();
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", username=" + username + ", password=" + password + ", token="
				+ token + ", deal=" + deal + "]";
	}
}