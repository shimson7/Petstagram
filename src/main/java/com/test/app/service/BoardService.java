package com.test.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.common.JDBCUtil;
import com.test.app.model.vo.BoardSet;
import com.test.app.model.vo.BoardVO;
import com.test.app.model.vo.ReplyVO;

public interface BoardService {
	public void insertBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	public List<BoardVO> getBoardListWriter(BoardVO vo);
	public List<BoardVO> getBoardListMemid(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	
	//댓글
	public boolean insertReply(ReplyVO vo);
	public boolean deleteReply(ReplyVO vo);
	public ArrayList<BoardSet> selectAll(BoardVO vo);
	public ArrayList<ReplyVO> getReply(ReplyVO vo);
}