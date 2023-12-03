package com.bookstore.servlet.shoppingCart;

import java.util.Collection;

public interface IGouwuche{
	/**
	 * 向购物车中添加一件商品（1.商品不存在，添加一件；2.商品存在，数量加一）
	 */
	public abstract void addItem(GouwucheItem gwcItem);
	
	/**
	 * 修改购物车中某种商品的数量 (商品编号和商品数量)
	 */
	public abstract void updateItemNum(int id, int num);
	
	/**
	 * 删除购物车中的某种商品(商品编号)
	 */
	public abstract void deleteGwcItem(int id);
	
	/**
	 * 清空购物车中的所有商品
	 */
	public abstract void clear();
	
	/**
	 * 得到原始总价
	 */
	public abstract double getOldPrices();
	
	/**
	 * 得到会员价
	 */
	public abstract double getHyPrices();
	
	/**
	 * 得到优惠总价
	 */
	public abstract double getYhPrices();
	
	/**
	 * 得到购物车中所有的商品
	 */
	public Collection<GouwucheItem> getAllItems();
}
