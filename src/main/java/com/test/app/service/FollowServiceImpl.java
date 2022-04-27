package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.model.dao.FollowDAO;
import com.test.app.model.vo.FollowVO;

@Service("followService")
public class FollowServiceImpl implements FollowService{

	@Autowired // DI
	private FollowDAO followDAO;
	
	@Override
	public void insertFollow(FollowVO vo) {
		// TODO Auto-generated method stub
		followDAO.insertFollow(vo);
	}

	@Override
	public void deleteFollow(FollowVO vo) {
		// TODO Auto-generated method stub
		followDAO.deleteFollow(vo);
	}

	@Override
	public List<FollowVO> getFollowList(FollowVO vo) {
		// TODO Auto-generated method stub
		return followDAO.getFollowList(vo);
	}

	@Override
	public List<FollowVO> getFollowerList(FollowVO vo) {
		// TODO Auto-generated method stub
		return followDAO.getFollowerList(vo);
	}

	@Override
	public int checkFollow(FollowVO vo) {
		// TODO Auto-generated method stub
		return followDAO.checkFollow(vo);
	}

}
