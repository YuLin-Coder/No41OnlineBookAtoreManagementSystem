package com.bookstore.servlet.shoppingCart;

import java.util.Collection;

public interface IGouwuche{
	/**
	 * ���ﳵ�����һ����Ʒ��1.��Ʒ�����ڣ����һ����2.��Ʒ���ڣ�������һ��
	 */
	public abstract void addItem(GouwucheItem gwcItem);
	
	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ������ (��Ʒ��ź���Ʒ����)
	 */
	public abstract void updateItemNum(int id, int num);
	
	/**
	 * ɾ�����ﳵ�е�ĳ����Ʒ(��Ʒ���)
	 */
	public abstract void deleteGwcItem(int id);
	
	/**
	 * ��չ��ﳵ�е�������Ʒ
	 */
	public abstract void clear();
	
	/**
	 * �õ�ԭʼ�ܼ�
	 */
	public abstract double getOldPrices();
	
	/**
	 * �õ���Ա��
	 */
	public abstract double getHyPrices();
	
	/**
	 * �õ��Ż��ܼ�
	 */
	public abstract double getYhPrices();
	
	/**
	 * �õ����ﳵ�����е���Ʒ
	 */
	public Collection<GouwucheItem> getAllItems();
}
