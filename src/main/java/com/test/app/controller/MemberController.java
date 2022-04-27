package com.test.app.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.app.model.dao.FollowDAO;
import com.test.app.model.dao.MemberDAO;
import com.test.app.model.vo.FollowVO;
import com.test.app.model.vo.MemberVO;
import com.test.app.service.BoardService;
import com.test.app.service.FollowService;
import com.test.app.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private FollowService followService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO vo,MemberDAO memberDAO,HttpSession session) {
		vo=memberDAO.getMember(vo);
		if(vo==null){
			System.out.println("로그 : 로그인 실패");
			return "redirect:login.jsp";
		}
		session.setAttribute("member", vo);
		System.out.println("로그 : 로그인 성공");
		return "redirect:main.do";
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그 : 로그아웃 성공");
		return "redirect:main.do";
	}
	@RequestMapping(value="/insertMember.do")
	public String insertMember(MemberVO vo,MemberDAO memberDAO) throws IllegalStateException, IOException {
		memberDAO.insertMember(vo);
		System.out.println("로그 : 회원가입 완료");
		return "redirect:login.jsp";
	}
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(MemberVO vo,MemberDAO memberDAO,HttpSession session) {
		memberDAO.deleteMember(vo);
		session.invalidate();
		System.out.println("로그 : 회원탈퇴 완료");
		return "redirect:main.do";
	}
	@RequestMapping(value="/updateMember.do")
	public String updateMember(MemberVO vo,MemberDAO memberDAO,HttpSession session) throws IllegalStateException, IOException {
		// 파일 수정 로직
		   MultipartFile uploadFile=vo.getPath(); 
		   System.out.println(vo);
		   if(!uploadFile.isEmpty()) {
		      // 로직수행
			   String fileName=uploadFile.getOriginalFilename();
			      System.out.println("파일명: "+fileName);
			      uploadFile.transferTo(new File("D:\\Shim\\workspace3\\SNS_Project\\src\\main\\webapp\\NewFeed\\"+fileName));
			      vo.setMemPic(fileName);
		   }
		   else {
		      vo.setMemPic("TestImg.png");
		   }
		memberDAO.updateMember(vo);
		System.out.println(vo);
		session.setAttribute("member", vo);
		System.out.println("로그 : 멤버수정 완료");
		return "redirect:mypage.do";
	}
	@RequestMapping(value="/getMemberlist.do")
	public String getMemberList(MemberVO vo,MemberDAO memberDAO,HttpSession session) {
		session.setAttribute("memberlist", vo);
		memberDAO.getMemberList(vo);
		System.out.println("로그 : 멤버 전체 불러오기 완료");
		
		
		return "main.do";
	}

	@RequestMapping(value="/insertFollow.do")
	public String insertFollow(FollowVO fvo,FollowDAO followDAO, Model model) {
		followService.checkFollow(fvo);
		System.out.println(followService.checkFollow(fvo) + " 0이면 팔로우 추가, 1이면 정보가 있으므로 스킵");
		if(followService.checkFollow(fvo)==0) {
			followDAO.insertFollow(fvo);
			System.out.println(fvo);
			System.out.println("로그 : 팔로우 추가 완료");
		}
		return "main.do";
	}
	@RequestMapping(value="/deleteFollow.do")
	public String deleteFollow(FollowVO fvo,FollowDAO followDAO) {
		followDAO.deleteFollow(fvo);
		System.out.println("로그 : 팔로우 삭제 완료");
		return "main.do";
	}
	
	
}
