package com.bookstore.bean;
//图书类别表
public class BookType {
	//属性
	private int bookTypeId;//图书类别编号
	private int parentId;//父类编号
	private String bookTypeName;//图书类别名称
	private String context;//备注
	private int isDelete;//1表示可用，0表示不可用
	
	//空构造方法
	public BookType() {
		// TODO Auto-generated constructor stub
	}

	//带参数的构造方法
	public BookType(int bookTypeId, int parentId, String bookTypeName,
			String context, int isDelete) {
		super();
		this.bookTypeId = bookTypeId;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "BookType [bookTypeId=" + bookTypeId + ", parentId=" + parentId
				+ ", bookTypeName=" + bookTypeName + ", context=" + context
				+ ", isDelete=" + isDelete + "]";
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookTypeId;
		result = prime * result
				+ ((bookTypeName == null) ? 0 : bookTypeName.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + isDelete;
		result = prime * result + parentId;
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
		BookType other = (BookType) obj;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (bookTypeName == null) {
			if (other.bookTypeName != null)
				return false;
		} else if (!bookTypeName.equals(other.bookTypeName))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (parentId != other.parentId)
			return false;
		return true;
	}
}
