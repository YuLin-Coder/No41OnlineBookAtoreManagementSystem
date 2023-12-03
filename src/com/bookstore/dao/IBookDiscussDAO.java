package com.bookstore.dao;
//����
import java.util.List;

import com.bookstore.bean.BookDiscuss;

public interface IBookDiscussDAO {
	//��ҳ��
	public int getPageCount(int pageSize);
	//�õ���ǰҳ����������
	public List<BookDiscuss> getNowPage(int nowPage, int pageSize);
	public boolean save(BookDiscuss bookDiscuss);
	public boolean update(BookDiscuss bookDiscuss);
	public boolean delete(int id);
	public BookDiscuss findById(int id);
	public List<BookDiscuss> findAll();
	public List<BookDiscuss> findByBookId(int bookId);
}
