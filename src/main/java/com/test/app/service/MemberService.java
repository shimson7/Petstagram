package com.test.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.common.JDBCUtil;
import com.test.app.model.vo.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO vo);
	public MemberVO getMember(MemberVO vo);
	public List<MemberVO> getMemberList(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	
}


