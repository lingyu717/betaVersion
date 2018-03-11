package com.example.moduleTow;

import java.io.Serializable;

public class Urses implements Serializable {
	private String name; //账号
	private String password; //密码
	private String nickname; //昵称
	private String Realname;//真实姓名
	private String IDCard;//身份证号
	private String level;//级别
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return Realname;
	}
	public void setRealname(String realname) {
		Realname = realname;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
