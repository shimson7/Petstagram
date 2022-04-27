package com.test.app.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bid; // PK
	private String memId; // 아이디
	private String pic; // 사진 저장할 경로
	private MultipartFile path; // 사진파일
	private String writer; // 닉네임
	private String content; // 글 
	private int rpcnt; // 댓글개수
	private String bdate; // sysdate로 처리
	private String searchCondition;
	private String searchKeyword;
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public MultipartFile getPath() {
		return path;
	}

	public void setPath(MultipartFile path) {
		this.path = path;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRpcnt() {
		return rpcnt;
	}

	public void setRpcnt(int rpcnt) {
		this.rpcnt = rpcnt;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", memId=" + memId + ", pic=" + pic + ", writer=" + writer + ", content=" + content
				+ ", rpcnt=" + rpcnt + ", bdate=" + bdate + "]";
	}
	
	
}
