package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.News;

//����
public interface INewsDAO {
	//�õ���ҳ��
	public int getPageCount(int pageSize);
	//�õ���ǰҳ�ľ�������
	public List<News> getNowPage(int nowPage, int pageSize);
	public boolean save(News news);
	public boolean update(News news);
	public boolean delete(int id);
	public News findById(int id);
	public List<News> findAll();
	//�ҳ���������
	public List<News> findTopNine(int num);
}
