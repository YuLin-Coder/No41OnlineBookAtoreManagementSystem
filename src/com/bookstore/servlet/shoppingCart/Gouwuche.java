package com.bookstore.servlet.shoppingCart;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Gouwuche implements IGouwuche{
	private Map<Integer, GouwucheItem> items = new  Hashtable<Integer, GouwucheItem>();
	//���ﳵ�������Ʒ��1.��Ʒ�����ڣ����һ����2.��Ʒ���ڣ�������һ��
	public void addItem(GouwucheItem gwcItem) {
		//�õ�������Ʒ�ı��
		Set<Integer> ids = items.keySet();
		//��Ʒ�Ѿ�����
		if(ids.contains(gwcItem.getBookId())) {
			//ͨ�����õ�ֵ
			GouwucheItem oldItem = items.get(gwcItem.getBookId());
			oldItem.setNum(oldItem.getNum() + 1);
		} else {
			items.put(gwcItem.getBookId(), gwcItem);
		}
	}

	public void updateItemNum(int id, int num) {
		GouwucheItem item = items.get(id);
		item.setNum(num);
	}

	public void deleteGwcItem(int id) {
		items.remove(id);
	}

	public void clear() {
		items.clear();
	}

	public double getOldPrices() {
		double sumPrice = 0;
		Collection<GouwucheItem> shangpin = items.values();
		for (GouwucheItem gouwucheItem : shangpin) {
			sumPrice += (gouwucheItem.getPrice() * gouwucheItem.getNum());
		}
		return sumPrice;
	}

	public double getHyPrices() {
		double sumPrice = 0;
		Collection<GouwucheItem> shangpin = items.values();
		for (GouwucheItem gouwucheItem : shangpin) {
			sumPrice += gouwucheItem.getHyprice() * gouwucheItem.getNum();
		}
		return sumPrice;
	}

	public double getYhPrices() {
		return getOldPrices() - getHyPrices();
	}

	public Collection<GouwucheItem> getAllItems() {
		return items.values();
	} 
}
