package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.SysAdmin;
import com.bookstore.dao.ISysAdminDAO;
import com.bookstore.db.DBManager;

public class SysAdminDAOImpl implements ISysAdminDAO{

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from sysAdmin";
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

	public List<SysAdmin> getNowPage(int nowPage, int pageSize) {
		List<SysAdmin> admins = new Vector<SysAdmin>();
		String sql = "select * from sysAdmin limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				SysAdmin admin = new SysAdmin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPwd(rs.getString(3));
				admin.setAdminType(rs.getInt(4));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return admins;
	}

	public boolean save(SysAdmin sysadmin) {
		String sql = "insert into " +
				"sysAdmin(adminName,pwd,adminType) " +
				"values('"+sysadmin.getAdminName()+"','"+sysadmin.getPwd()+"',"+sysadmin.getAdminType()+")";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(SysAdmin sysAdmin) {
		String sql = "update sysAdmin set adminName='"+sysAdmin.getAdminName()+"',pwd='"+sysAdmin.getPwd()+"'," +
				"adminType="+sysAdmin.getAdminType()+" where adminId = "+sysAdmin.getAdminId()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from sysAdmin where adminId = "+id+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public SysAdmin findById(int id) {
		String sql = "select adminId,adminName,pwd,adminType from sysAdmin where adminId = "+id+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		SysAdmin admin = new SysAdmin();
		try {
			if(rs.next()) {
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPwd(rs.getString(3));
				admin.setAdminType(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return admin;
	}

	public List<SysAdmin> findAll() {
		List<SysAdmin> admins = new Vector<SysAdmin>();
		String sql = "select adminId,adminName,pwd,adminType from sysAdmin";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				SysAdmin admin = new SysAdmin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPwd(rs.getString(3));
				admin.setAdminType(rs.getInt(4));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return admins;
	}

	/**
	 * 根据用户名与密码找到相关信息
	 * 如果找到则返回改实体的所有信息；如果找不到，返回null
	 */
	public SysAdmin findByNameAndPwd(String name, String pwd) {
		String sql = "select adminId,adminName,pwd,adminType from sysAdmin " +
				"where adminName = '"+ name +"' and pwd = '"+ pwd +"'";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		SysAdmin sysAdmin = null;
		try {
			if(rs.next()) {
				sysAdmin = new SysAdmin
						(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return sysAdmin;
	}
}
