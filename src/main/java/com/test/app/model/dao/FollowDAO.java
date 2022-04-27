package com.test.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.model.vo.FollowVO;

@Repository("followDAO") //
public class FollowDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;

	private final String Follow_Insert="insert into follow values((select nvl(max(fid),0)+1 from follow),?,?)"; // ���� �Ϸ�
	private final String Follow_Delete="delete from follow where follower=? and followee=?"; //
	private final String Follow_ShowAll="select * from follow where follower=?";
	private final String Follower_ShowAll="select * from follow where followee=?";
	
	//팔로우 체크용으로 추가
	private final String Follow_SelectOne="select * from follow where follower=? and followee=?";
	
	// 팔로우하기
	public void insertFollow(FollowVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(Follow_Insert);
			pstmt.setString(1, vo.getFollower());
			pstmt.setString(2, vo.getFollowee());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	// 팔로우 유무 확인
	public int checkFollow(FollowVO vo) {
		conn=JDBCUtil.connect();
		int num=0;
		try {
			pstmt=conn.prepareStatement(Follow_SelectOne);
			pstmt.setString(1, vo.getFollower());
			pstmt.setString(2, vo.getFollowee());
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return num;
	}
	
	// 언팔로우
	public void deleteFollow(FollowVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(Follow_Delete);
			pstmt.setString(1, vo.getFollower());
			pstmt.setString(2, vo.getFollowee());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 팔로우 전체 리스트 가져오기
	public List<FollowVO> getFollowList(FollowVO vo) {
		List<FollowVO> datas=new ArrayList<FollowVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(Follow_ShowAll);
			pstmt.setString(1, vo.getFollower());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FollowVO data=new FollowVO();
				data.setFid(rs.getInt("fid"));
				data.setFollower(rs.getString("follower"));
				data.setFollowee(rs.getString("followee"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	// 팔로워 전체 가져오기
	public List<FollowVO> getFollowerList(FollowVO vo) {
		List<FollowVO> datas=new ArrayList<FollowVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(Follower_ShowAll);
			pstmt.setString(1, vo.getFollower());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FollowVO data=new FollowVO();
				data.setFid(rs.getInt("fid"));
				data.setFollower(rs.getString("follower"));
				data.setFollowee(rs.getString("followee"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}


}
