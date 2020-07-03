package com.spring.mvc.commons;

//굳이 PageVO를 생성하느니 PageVO를 상속해버리자!!!
public class SearchVO extends PageVO {
	
	private String keyword;
	private String condition;
	
	//검색을 안하고 싶을수도 있으므로 기본 생성자에 공백을 넣어놓음! null이 나오면 안되기 때문!
	public SearchVO() {
		this.keyword = "";
		this.condition = "";
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	

}
