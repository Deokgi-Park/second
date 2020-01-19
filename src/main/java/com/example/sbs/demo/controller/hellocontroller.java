package com.example.sbs.demo.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbs.demo.dao.ArticleDao;
/**
 * @가 붙은 건 어노테이션이라고 한다. 어노테이션은 자바나 개발자, 스프링같은 프레임워크에게 알려주는 정보다. 특정 어노테이션을 만나면 각자
 *    어떻게 작동하게 될지 미리 정의되어 있다.
 */
@Controller // 여기서 @Controller 어노테이션은 스프링 프레임워크에게 이 클래스가 컨트롤러 역할을 할 클래스임을 알리고 이를 스프링 컨테이너에
			// 준비해놓으라는 의미
public class hellocontroller {
	
	ArticleDao dao = new ArticleDao();
	
	@RequestMapping("addArticle")
	@ResponseBody
	public String hello(int id, String title, String body, String nick) {
		
		dao.insertArticle(id, title, body, nick);
		
		return "게시물 저장 완료했습니다.";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public ArrayList<Article> List() {		
		
		return dao.getArticles();
		
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public String remove(int id) {
		
		dao.removeArticle(id);
		
		return id+"번 "+"게시물 삭제했습니다.";
		
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public String edit(int id, String title, String body, String nick) {
		
		dao.editArticle(id, title, body, nick);
		
		return id+"번 "+"게시물 변경을 완료했습니다.";
	}
}
