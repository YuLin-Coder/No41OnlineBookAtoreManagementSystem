package com.bookstore.bean;

import java.util.Date;

//图书基本信息表

public class BookInfo {
	//属性
	private int bookId;//图书编号
	private String bookName;//图书名称
	private int booktypeId;//图书类别编号
	private String author;//作者
	private String pbName;//出版社名称
	private String context;//图书介绍
	private String smallImg;//图书图片
	private String bigImg;//图书图片
	private double price;//价格
	private Date pbdate;//出版日期
	private double hyprice;//会员价
	private int bookStates;//图书状态 0不可用，1可用
	private Date sjdate;//上架日期
	private int num;//存货量
	private int saleCount;//累计销售量
	
	//方法
	public BookInfo() {
		// TODO Auto-generated constructor stub
	}

	public BookInfo(int bookId, String bookName, int booktypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			int price, Date pbdate, int hyprice, int bookStates, Date sjdate,
			int num, int saleCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
	}

	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName
				+ ", booktypeId=" + booktypeId + ", author=" + author
				+ ", pbName=" + pbName + ", context=" + context + ", smallImg="
				+ smallImg + ", bigImg=" + bigImg + ", price=" + price
				+ ", pbdate=" + pbdate + ", hyprice=" + hyprice
				+ ", bookStates=" + bookStates + ", sjdate=" + sjdate
				+ ", num=" + num + ", saleCount=" + saleCount + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBooktypeId() {
		return booktypeId;
	}

	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public Date getPbdate() {
		return pbdate;
	}

	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}

	public double getHyprice() {
		return hyprice;
	}

	public void setHyprice(double d) {
		this.hyprice = d;
	}

	public int getBookStates() {
		return bookStates;
	}

	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}

	public Date getSjdate() {
		return sjdate;
	}

	public void setSjdate(Date sjdate) {
		this.sjdate = sjdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + booktypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		long temp;
		temp = Double.doubleToLongBits(hyprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + num;
		result = prime * result + ((pbName == null) ? 0 : pbName.hashCode());
		result = prime * result + ((pbdate == null) ? 0 : pbdate.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleCount;
		result = prime * result + ((sjdate == null) ? 0 : sjdate.hashCode());
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (booktypeId != other.booktypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (Double.doubleToLongBits(hyprice) != Double
				.doubleToLongBits(other.hyprice))
			return false;
		if (num != other.num)
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (pbdate == null) {
			if (other.pbdate != null)
				return false;
		} else if (!pbdate.equals(other.pbdate))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (saleCount != other.saleCount)
			return false;
		if (sjdate == null) {
			if (other.sjdate != null)
				return false;
		} else if (!sjdate.equals(other.sjdate))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		return true;
	}
}
