package com.test.app.model.vo;

import java.util.ArrayList;

public class BoardSet {
	private BoardVO boardVO;
	private ArrayList<ReplyVO> replyList=new ArrayList<ReplyVO>();
	private String follow = "false";
	private String memberVO;
	

	public String getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(String memberVO) {
		this.memberVO = memberVO;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public BoardVO getBoardVO() {
		return boardVO;
	}
	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}
	public ArrayList<ReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(ArrayList<ReplyVO> replyList) {
		this.replyList = replyList;
	}
	
	@Override
	public String toString() {
		return "BoardSet [boardVO=" + boardVO + ", replyList=" + replyList + "]";
	}
}
