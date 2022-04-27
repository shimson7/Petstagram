package com.test.app.model.vo;

public class FollowVO {
	private int fid;
	private String follower;
	private String followee;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getFollowee() {
		return followee;
	}
	public void setFollowee(String followee) {
		this.followee = followee;
	}
	@Override
	public String toString() {
		return "FollowVO [fid=" + fid + ", follower=" + follower + ", followee=" + followee + "]";
	}
	
}
