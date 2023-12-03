package com.bookstore.bean;
//书评表

public class BookDiscuss {
	//属性
	private int disId;//书评编号
	private int bookId;//图书编号
	private int custId;//用户编号
	private String context;//备注
	private int states;//书评状态
	
	//方法
	public BookDiscuss() {
		// TODO Auto-generated constructor stub
	}

	public BookDiscuss(int disId, int bookId, int custId, String context,
			int states) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.custId = custId;
		this.context = context;
		this.states = states;
	}

	@Override
	public String toString() {
		return "bookDiscuss [disId=" + disId + ", bookId=" + bookId
				+ ", custId=" + custId + ", context=" + context + ", states="
				+ states + "]";
	}

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + custId;
		result = prime * result + disId;
		result = prime * result + states;
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
		BookDiscuss other = (BookDiscuss) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (custId != other.custId)
			return false;
		if (disId != other.disId)
			return false;
		if (states != other.states)
			return false;
		return true;
	}
}
