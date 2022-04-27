package com.test.app.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memNickname; // 닉네임
	private String memPic; // 프로필 사진
	public MultipartFile path;
	private int memfollowee;
	private int memfollower;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemPic() {
		return memPic;
	}
	public void setMemPic(String memPic) {
		this.memPic = memPic;
	}
	public MultipartFile getPath() {
		return path;
	}
	public void setPath(MultipartFile path) {
		this.path = path;
	}
	public int getMemfollowee() {
		return memfollowee;
	}
	public void setMemfollowee(int memfollowee) {
		this.memfollowee = memfollowee;
	}
	public int getMemfollower() {
		return memfollower;
	}
	public void setMemfollower(int memfollower) {
		this.memfollower = memfollower;
	}
	

}
