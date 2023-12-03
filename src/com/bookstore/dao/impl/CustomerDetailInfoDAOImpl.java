package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.CustomerDetailInfo;
import com.bookstore.dao.ICustomerDetailInfoDAO;
import com.bookstore.db.DBManager;

//用户详细信息表测试用例

public class CustomerDetailInfoDAOImpl implements ICustomerDetailInfoDAO {

	public boolean save(CustomerDetailInfo cd) {
		String sql = 
				"insert into customerDetailInfo" +
				"(tel,address,sex,age,countMoney,qq) " +
				"values" +
				"('" + cd.getTel() + "','" + cd.getAddress()
				+ "','" + cd.getSex() + "'," + cd.getAge() + "," + cd.getCountMoney()
				+ ",'" + cd.getQq() + "')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(CustomerDetailInfo cd) {
		String sql = "update customerDetailInfo set " +
				"tel = '" + cd.getTel() + "', address = '" + cd.getAddress() + "', sex = " + cd.getSex()
				+ ", age = " + cd.getAge() + ", countMoney = " + cd.getCountMoney() + ", qq = '" + cd.getQq() + "' " +
						"where custId = "+ cd.getCustId() +"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from customerDetailInfo where custId = " + id + "";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public CustomerDetailInfo findById(int id) {
		String sql = "select custId,tel,address,sex,age,countMoney,qq from customerDetailInfo where custId = " + id + "";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		CustomerDetailInfo info = new CustomerDetailInfo();
		try {
			if(rs.next()) {
				info.setCustId(rs.getInt(1));
				info.setTel(rs.getString(2));
				info.setAddress(rs.getString(3));
				info.setSex(rs.getInt(4));
				info.setAge(rs.getInt(5));
				info.setCountMoney(rs.getDouble(6));
				info.setQq(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return info;
	}

	public List<CustomerDetailInfo> findAll() {
		List<CustomerDetailInfo> infos = new Vector<CustomerDetailInfo>();
		String sql = "select custId,tel,address,sex,age,countMoney,qq from customerDetailInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				CustomerDetailInfo detailInfo = new CustomerDetailInfo();
				detailInfo.setCustId(rs.getInt(1));
				detailInfo.setTel(rs.getString(2));
				detailInfo.setAddress(rs.getString(3));
				detailInfo.setSex(rs.getInt(4));
				detailInfo.setAge(rs.getInt(5));
				detailInfo.setCountMoney(rs.getDouble(6));
				detailInfo.setQq(rs.getString(7));
				infos.add(detailInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return infos;
	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from customerDetailInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		pageCount = rowCount / pageSize;
		if(rowCount % pageSize != 0) {
			pageCount++;
		}
		return pageCount;
	}

	public List<CustomerDetailInfo> getNowPage(int nowPage, int pageSize) {
		List<CustomerDetailInfo> infos = new Vector<CustomerDetailInfo>();
		String sql = "select * from customerDetailInfo limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				CustomerDetailInfo detailInfo = new CustomerDetailInfo();
				detailInfo.setCustId(rs.getInt(1));
				detailInfo.setTel(rs.getString(2));
				detailInfo.setAddress(rs.getString(3));
				detailInfo.setSex(rs.getInt(4));
				detailInfo.setAge(rs.getInt(5));
				detailInfo.setCountMoney(rs.getDouble(6));
				detailInfo.setQq(rs.getString(7));
				infos.add(detailInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return infos;
	}
}
