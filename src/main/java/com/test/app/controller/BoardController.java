package com.test.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.test.app.model.vo.BoardSet;
import com.test.app.model.vo.BoardVO;
import com.test.app.model.vo.FollowVO;
import com.test.app.model.vo.MemberVO;
import com.test.app.model.vo.ReplyVO;
import com.test.app.service.BoardService;
import com.test.app.service.FollowService;
import com.test.app.service.MemberService;

@Controller
public class BoardController {
	// 1. Controller 교체
	// 2. 반환타입의 변경 -> ModelAndView(무엇을 보낼지_정보_datas,data,member,... + 어디로 가야하는지_경로)
	@Autowired
	private BoardService boardService;
	@Autowired
	private FollowService followService;
	@Autowired
	private MemberService memberService;

	@ModelAttribute("conMap") // @RequestMapping이 설정된 메서드보다 먼저 수행됨
	public Map<String,String> searchConditionMap() {
		Map<String,String> conMap=new HashMap<String,String>();
		conMap.put("제목", "title");
		conMap.put("작성자", "writer");
		conMap.put("내용", "content");
		return conMap; // 반환값은 자동으로 Model에 저장
	}

	@RequestMapping(value="/main.do")
	public String getBoardList(BoardVO vo,MemberVO mvo,FollowVO fvo,HttpSession session,Model model) {
		System.out.println("로그 : 메인으로 가자");
		System.out.println(vo);
		//      model.addAttribute("datas",boardService.getBoardList(vo)); // 메인을 갈때 모든 기존 글을 확인 할 수 있어야함
		//      System.out.println("로그 : getBoardList(글 전체보기) 실행완료");
		ArrayList<BoardSet> bdatas = boardService.selectAll(vo);
		mvo=(MemberVO)(session.getAttribute("member"));
		if(mvo!=null) {
			fvo.setFollower(mvo.getMemId());
			System.out.println(fvo);
			List<FollowVO> fdatas = followService.getFollowList(fvo);
			System.out.println(fdatas);
			for (int i = 0; i < bdatas.size(); i++) {
				
				mvo = new MemberVO();
				String memId = bdatas.get(i).getBoardVO().getMemId();
				mvo.setMemId(memId);
				mvo = memberService.getMember(mvo);
				bdatas.get(i).setMemberVO(mvo.getMemPic());
				
				for (int j = 0; j < fdatas.size(); j++) {
					if(bdatas.get(i).getBoardVO().getMemId().equals(fdatas.get(j).getFollowee())) { // 글쓴이 팔로우당하는사람
						bdatas.get(i).setFollow("true");
						break;
					}
					
				}
			}
		}
		
		
		 	for (int i = 0; i < bdatas.size(); i++) {
			mvo = new MemberVO();
			String memId = bdatas.get(i).getBoardVO().getMemId();
			mvo.setMemId(memId);
			mvo = memberService.getMember(mvo);
			bdatas.get(i).setMemberVO(mvo.getMemPic());
			}
		
		
		model.addAttribute("datas", bdatas); // 댓글리스트도 다 가져와야함
		System.out.println("로그 : 글, 댓글 전체보기 실행완료");
		return "main.jsp";
	}
	@RequestMapping(value="/board.do")
	public String getBoard(BoardVO vo,ReplyVO rvo,Model model) {
		System.out.println("컨트롤러 로그" + rvo);
		vo=boardService.getBoard(vo);
		ArrayList<ReplyVO> replyList=boardService.getReply(rvo);
		System.out.println(vo);
		System.out.println(replyList);
		model.addAttribute("data", vo); // ☆
		model.addAttribute("datas", replyList); // ☆
		return "common/modal.jsp"; // common 폴더 안에 modal.jsp가 있으니 경로 설정 다시 알아볼것
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		// 파일업로드 로직
		MultipartFile uploadFile=vo.getPath();
		System.out.println(vo);
		if(!uploadFile.isEmpty()) {
			// 로직수행
			String fileName=uploadFile.getOriginalFilename();
			System.out.println("파일명: "+fileName);
			uploadFile.transferTo(new File("D:\\Shim\\workspace3\\SNS_Project\\src\\main\\webapp\\NewFeed\\"+fileName));
			vo.setPic(fileName);
		}
		else {
			vo.setPic("TestImg.png");
		}
		boardService.insertBoard(vo);
		System.out.println("로그 : DB 글 저장 완료");
		return "redirect:main.do";
	}
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		System.out.println("로그 : 글 삭제 완료");
		return "redirect:main.do";
	}
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {  // ☆
		System.out.println(" null 업데이트 이슈 확인: "+vo.getPic());	// session에 저장해둔 정보가 먼저 setter
		System.out.println(" null 업데이트 이슈 확인: "+vo.getContent());		// 이후에 파라미터로 들어온 정보가 나중에 setter
		System.out.println(" null 업데이트 이슈 확인: "+vo.getBid());
		System.out.println("로그 : 글 수정 다녀간다");
		boardService.updateBoard(vo);
		return "redirect:main.do";
	}

	// 업데이트 페이지로 이동하는 do
	@RequestMapping(value="/updatePage.do")
	public String updatePage(@ModelAttribute("data")BoardVO vo, Model model) {
		System.out.println(" null 업데이트 이슈 확인: "+vo.getPic());	
		System.out.println(" null 업데이트 이슈 확인: "+vo.getContent());		
		System.out.println(" null 업데이트 이슈 확인: "+vo.getBid());
		System.out.println("로그 : 글 수정 다녀간다");

		vo = boardService.getBoard(vo);
		model.addAttribute("data", vo);
		return "UpdateBoard.jsp";
	}
	@RequestMapping(value="/mypage.do")
	public String getBoardListMemid(BoardVO vo,Model model) {
		System.out.println("로그 : 마이페이지로 가자");
		System.out.println("마이페이지 VO로그" + vo);
		model.addAttribute("datas", boardService.getBoardListMemid(vo));
		System.out.println("마이페이지 로그" + boardService.getBoardListMemid(vo));
		return "Mypage.jsp";
	}
	@RequestMapping(value="/insertReply.do")
	public String insertReply(ReplyVO vo,Model model,HttpSession session) {
		MemberVO member=(MemberVO)session.getAttribute("member");
		vo.setMemNickname(member.getMemNickname());
		boardService.insertReply(vo);

		System.out.println("로그 : 댓글추가"+vo);
		return "main.do";
	}
	@RequestMapping(value="/deleteReply.do")
	public String deleteReply(ReplyVO vo) {
		boardService.deleteReply(vo);
		System.out.println("로그 : 댓글삭제");
		return "main.do";
	}


}