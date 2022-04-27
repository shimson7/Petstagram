package com.test.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.model.dao.BoardDAO;
import com.test.app.model.vo.BoardSet;
import com.test.app.model.vo.BoardVO;
import com.test.app.model.vo.ReplyVO;

@Service("boardService") // Shape: Circle,Rect,Tri,...   @Component: @Service,@Repository,...
public class BoardServiceImpl implements BoardService {

	@Autowired // DI
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	@Override
	public List<BoardVO> getBoardListWriter(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardListWriter(vo);
	}
	@Override
	public List<BoardVO> getBoardListMemid(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardListMemid(vo);
	}
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public boolean insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.insertReply(vo);
	}

	@Override
	public boolean deleteReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.deleteReply(vo);
	}

	@Override
	public ArrayList<BoardSet> selectAll(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.selectAll(vo);
	}

	@Override
	public ArrayList<ReplyVO> getReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getReply(vo);
	}


}
