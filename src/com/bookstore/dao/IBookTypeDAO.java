package com.bookstore.dao;

//ͼ�����
import java.util.List;

import com.bookstore.bean.BookType;

//�ӿ���
public interface IBookTypeDAO {
	//�õ���ҳ��
	public int getPageCount(int pageSize);
	//�õ���ǰҳ�ľ�������
	public List<BookType> getNowPage(int nowPage, int pageSize);
	public boolean save(BookType bookType);
	public boolean update(BookType bookType);
	public boolean delete(int id);
	public BookType findById(int id);
	public List<BookType> findAll();
	public List<BookType> findByParentId(int parentId);
}
