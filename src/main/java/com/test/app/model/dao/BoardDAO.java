package com.test.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.model.vo.BoardSet;
import com.test.app.model.vo.BoardVO;
import com.test.app.model.vo.ReplyVO;

@Repository("boardDAO") // 
public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;


	// 게시판
	private final String BOARD_INSERT="insert into board(bid,memId,pic,writer,content) values((select nvl(max(bid),0)+1 from board),?,?,?,?)";
	private final String BOARD_SELECTONE="select * from board where bid=?";
	//전부 보여주기
	private final String BOARD_SELECTALL="select * from board order by bid desc";
	//내가 쓴것만 보여주기
	private final String BOARD_SELECTALL_MEMID="select * from board where memId=?";
	private final String BOARD_SELECTALL_WRITER="select * from board where writer like '%'||?||'%' order by bid desc";
	private final String BOARD_SELECTALL_CONTENT="select * from board where content like '%'||?||'%' order by bid desc";
	private final String BOARD_UPDATE="update board set pic=?,content=? where bid=?";
	private final String BOARD_DELETE="delete board where bid=? and memId=?";

	// 댓글
	private final String insert_reply="insert into reply (rid,bid,memNickname,msg) values((select nvl(max(rid),0)+1 from reply),?,?,?)";
	private final String delete_reply="delete from reply where rid=?";
	// 댓글 불러오기
	private final String REPLY_SHOWALL="select * from (select * from reply where bid=? order by rid desc) where rownum <=2";
	// 댓글 상세보기에서 다 불러오기
	private final String REPLY_SELECTALL="select * from reply where bid=? order by rid desc";
	// 글 추가
	public void insertBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getPic());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	// 특정 글 검색이나 모달창 불러오기
	public BoardVO getBoard(BoardVO vo) {
		BoardVO data=null;
		conn=JDBCUtil.connect();
		try {
			System.out.println("DAO로그" + vo);
			pstmt=conn.prepareStatement(BOARD_SELECTONE);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setMemId(rs.getString("memId"));
				data.setPic(rs.getString("pic"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
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
	// 특정 글 검색이나 모달창 불러오기
	public ArrayList<ReplyVO> getReply(ReplyVO vo) {
		ArrayList<ReplyVO> replyList=new ArrayList<ReplyVO>();
		conn=JDBCUtil.connect();
		try {
			System.out.println("DAO로그" + vo);
			pstmt=conn.prepareStatement(REPLY_SELECTALL);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO data=new ReplyVO();
				data.setRid(rs.getInt("rid"));
				data.setBid(rs.getInt("bid"));
				data.setMemNickname(rs.getString("memNickname"));
				data.setMsg(rs.getString("msg"));
				data.setRdate(rs.getString("rdate"));
				replyList.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return replyList;
	}
	
	// 전체 글 불러오기
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setMemId(rs.getString("memId"));
				data.setPic(rs.getString("pic"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
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

	// 닉네임으로 쓴 글 조회 다 불러오기
	public List<BoardVO> getBoardListWriter(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			
			
			pstmt=conn.prepareStatement(BOARD_SELECTALL_WRITER);
			pstmt.setString(1, vo.getWriter());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setMemId(rs.getString("memId"));
				data.setPic(rs.getString("pic"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
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
	
	// ID 조회로 쓴 글 다 불러오기
	public List<BoardVO> getBoardListMemid(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			
			
			pstmt=conn.prepareStatement(BOARD_SELECTALL_MEMID); 
			pstmt.setString(1, vo.getMemId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setMemId(rs.getString("memId"));
				data.setPic(rs.getString("pic"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
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
	
	// 게시글 수정
	public void updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getPic());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	// 게시글 삭제
	public void deleteBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 댓글 추가
	public boolean insertReply(ReplyVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(insert_reply);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getMemNickname());
			pstmt.setString(3, vo.getMsg());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	
	// 댓글 수정		사용 X서 지웠음


	// 댓글 삭제
	public boolean deleteReply(ReplyVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(delete_reply);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}

	// 모든 글, 댓글 다 불러오기
		public ArrayList<BoardSet> selectAll(BoardVO vo) {
			ArrayList<BoardSet> datas=new ArrayList<BoardSet>();
			conn=JDBCUtil.connect();
			try {
				
				pstmt=conn.prepareStatement(BOARD_SELECTALL);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					BoardSet bs=new BoardSet();
					BoardVO boardVO=new BoardVO();
					boardVO.setBid(rs.getInt("bid"));
					boardVO.setMemId(rs.getString("memId"));
					boardVO.setPic(rs.getString("pic"));
					boardVO.setWriter(rs.getString("writer"));
					boardVO.setContent(rs.getString("content"));
					boardVO.setRpcnt(rs.getInt("rpcnt"));
					boardVO.setBdate(rs.getString("bdate"));
					bs.setBoardVO(boardVO);
				
					ArrayList<ReplyVO> replyList=new ArrayList<ReplyVO>();
					pstmt=conn.prepareStatement(REPLY_SHOWALL);
					pstmt.setInt(1, rs.getInt("bid"));
					
					ResultSet rs2=pstmt.executeQuery();
					while(rs2.next()) {
						ReplyVO replyVO=new ReplyVO();
						replyVO.setRid(rs2.getInt("rid"));
						replyVO.setBid(rs2.getInt("bid"));
						replyVO.setMemNickname(rs2.getString("memNickname"));
						replyVO.setMsg(rs2.getString("msg"));
						replyVO.setRdate(rs2.getString("rdate"));
						replyList.add(replyVO);
					}
					rs2.close();
					bs.setReplyList(replyList);
					
					datas.add(bs);
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
