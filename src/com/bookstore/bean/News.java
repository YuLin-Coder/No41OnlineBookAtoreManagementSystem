package com.bookstore.bean;

import java.util.Date;

//新闻表
public class News {
	//属性
	private int newsId;//新闻编号
	private String newTitle;//新闻标题
	private String context;//新闻内容
	private Date createTime;//新闻发布时间
	
	//方法
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int newsId, String newTitle, String context, Date createTime) {
		super();
		this.newsId = newsId;
		this.newTitle = newTitle;
		this.context = context;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newTitle=" + newTitle
				+ ", context=" + context + ", createTime=" + createTime + "]";
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((newTitle == null) ? 0 : newTitle.hashCode());
		result = prime * result + newsId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (newTitle == null) {
			if (other.newTitle != null)
				return false;
		} else if (!newTitle.equals(other.newTitle))
			return false;
		if (newsId != other.newsId)
			return false;
		return true;
	}
}
