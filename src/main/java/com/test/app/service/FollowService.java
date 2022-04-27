package com.test.app.service;

import java.util.List;

import com.test.app.model.vo.FollowVO;

public interface FollowService {
	// ����Ͻ� �޼���
	// �ٽ� ����
	// CRUD
	public void insertFollow(FollowVO vo); // �ȷο�
	public void deleteFollow(FollowVO vo); // ���ȷο�
	public List<FollowVO> getFollowList(FollowVO vo); // �ȷο� ��üȮ��
	public List<FollowVO> getFollowerList(FollowVO vo); // �ȷο� ��üȮ��
	public int checkFollow(FollowVO vo);
}
