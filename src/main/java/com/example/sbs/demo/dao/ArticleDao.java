package com.example.sbs.demo.dao;

import java.util.ArrayList;
import com.example.sbs.demo.controller.Article;

public class ArticleDao {
	
	ArrayList<Article> articles = new ArrayList<Article>();
	Article a = new Article();
	
	public void insertArticle(int id, String title, String body, String nick) {
		
		a.setId(id);
		a.setTitle(title);
		a.setBody(body);
		a.setNick(nick);
		
		articles.add(a);
	}
	
	public ArrayList<Article> getArticles(){
		
		return articles;
	}
	public void removeArticle(int id) {
		
		articles.remove(id-1);
		
	}
	public void editArticle(int id, String title, String body, String nick) {
		articles.remove(id);
		
		a.setId(id);
		a.setTitle(title);
		a.setBody(body);
		a.setNick(nick);
		
		articles.add(id, a);
	}	

}
