package com.test.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.test.app.common.JDBCUtil;
import com.test.app.model.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String MEMBER_INSERT="insert into member(memId, memPw, memNickname, memPic) values(?,?,?,?)";
	private final String MEMBER_SELECTONE="select * from member where memId=?";
	private final String MEMBER_SELECTALL="select * from member order by memId desc";
	private final String MEMBER_UPDATE="update member set memNickname=?,memPw=?,memPic=? where memId=?";
	private final String MEMBER_DELETE="delete member where memId=?";
	
	public void insertMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPw());
			pstmt.setString(3, vo.getMemNickname());
			pstmt.setString(4, vo.getMemPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void updateMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, vo.getMemNickname());
			pstmt.setString(2, vo.getMemPw());
			pstmt.setString(3, vo.getMemPic());
			pstmt.setString(4, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void deleteMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public MemberVO getMember(MemberVO vo) {
		MemberVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_SELECTONE);
			pstmt.setString(1, vo.getMemId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMemId(rs.getString("memId"));
				data.setMemPw(rs.getString("memPw"));
				data.setMemNickname(rs.getString("memNickname"));
				data.setMemPic(rs.getString("memPic"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	public List<MemberVO> getMemberList(MemberVO vo) {
		List<MemberVO> datas=new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMemId(rs.getString("memId"));
				data.setMemPw(rs.getString("memPw"));
				data.setMemNickname(rs.getString("memNickname"));
				data.setMemPic(rs.getString("memPic"));
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


