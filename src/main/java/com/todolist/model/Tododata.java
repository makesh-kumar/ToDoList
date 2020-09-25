/**
 * 
 */
package com.todolist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 *@author Makesh Kumar
 * 
 */
@Document(collection = "tododata")
public class Tododata {
	
	@Id
	private int dataId;
	private String userId;
	private String title;
	private String content;
	private String dtm;
	public Tododata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tododata(int dataId, String userId, String title, String content, String dtm) {
		super();
		this.dataId = dataId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.dtm = dtm;
	}
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDtm() {
		return dtm;
	}
	public void setDtm(String dtm) {
		this.dtm = dtm;
	}
	@Override
	public String toString() {
		return "tododata [dataId=" + dataId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", dtm=" + dtm + "]";
	}
	
	

}
