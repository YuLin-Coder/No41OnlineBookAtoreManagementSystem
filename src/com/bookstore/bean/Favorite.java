package com.bookstore.bean;

import java.util.Date;

//收藏夹表
public class Favorite {
	//属性
	private int favoriteId;//收藏夹号
	private int bookId;//图书编号
	private int custId;//用户编号
	private Date scdate;//收藏时间
	private String context;//备注
	
	//方法
	public Favorite() {
		// TODO Auto-generated constructor stub
	}

	public Favorite(int favoriteId, int bookId, int custId, Date scdate,
			String context) {
		super();
		this.favoriteId = favoriteId;
		this.bookId = bookId;
		this.custId = custId;
		this.scdate = scdate;
		this.context = context;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Date getScdate() {
		return scdate;
	}

	public void setScdate(Date scdate) {
		this.scdate = scdate;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", bookId=" + bookId
				+ ", custId=" + custId + ", context=" + context + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + custId;
		result = prime * result + favoriteId;
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
		Favorite other = (Favorite) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (custId != other.custId)
			return false;
		if (favoriteId != other.favoriteId)
			return false;
		return true;
	}
}
