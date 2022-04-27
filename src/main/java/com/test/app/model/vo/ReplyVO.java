package com.test.app.model.vo;

public class ReplyVO {
	private int rid; 
	private int bid; 
	private String memNickname; 
	private String msg; 
	private String rdate;
	private int rpcnt;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getRpcnt() {
		return rpcnt;
	}
	public void setRpcnt(int rpcnt) {
		this.rpcnt = rpcnt;
	}
	
	
	
}
