package com.bookstore.servlet.shoppingCart;
//��ʾ���ﳵ�е�һ����Ʒ

import javax.servlet.http.HttpServlet;

public class GouwucheItem extends HttpServlet {
	//����
	private int bookId;//ͼ����
	private String bookName;//ͼ������
	private String smallImg;//ͼ��ͼƬ
	private double price;//�۸�
	private double hyprice;//��Ա��
	private int num;//��������
	
	public GouwucheItem() {
		super();
	}

	public GouwucheItem(int bookId, String bookName, String smallImg,
			float price, float hyprice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
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

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public double getHyprice() {
		return hyprice;
	}

	public void setHyprice(double hyprice) {
		this.hyprice = hyprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
