package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.Employee;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IEmployeeDAO;
import com.bookstore.db.DBManager;

public class EmployeeDAOImpl implements IEmployeeDAO {

	public boolean delete(int id) {
		String sql = "delete from employee where empId = " + id;
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public List<Employee> findAll() {
		List<Employee> emps = new Vector<Employee>();
		String sql = 
			"select " +
			"	empId,empName, empAge,empBtd,empSex,isDelete " +
			"from " +
			"	employee " +
			"where " +
			"	isDelete = 1";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpAge(rs.getInt(3));
				emp.setEmpBtd(rs.getDate(4));
				emp.setEmpSex(rs.getInt(5));
				emp.setIsDelete(1);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return emps;
	}
	 
	public Employee findById(int id) {
		String sql = 
			"select " +
			" empId,empName, empAge,empBtd,empSex,isDelete " +
			"from " +
			"	employee " +
			"where " +
			"	empId = " + id;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		Employee emp = new Employee();
		try {
			if (rs.next()) {
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpAge(rs.getInt(3));
				emp.setEmpBtd(rs.getDate(4));
				emp.setEmpSex(rs.getInt(5));
				emp.setIsDelete(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return emp;
	}

	public boolean save(Employee employee) {
		String dateStr = DateConvert.convertToString(employee.getEmpBtd());
		String sql = 
			"insert into employee" +
			"	(empId, empName, empAge,empBtd,empSex, isDelete)" +
			"values" +
			"	( " + employee.getEmpId() + ", '" + employee.getEmpName() + "'," + employee.getEmpAge() + 
			",'" + dateStr + "'," + employee.getEmpSex() +"," + employee.getIsDelete() + ")";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(Employee employee) {
		String dateStr = DateConvert.convertToString(employee.getEmpBtd());
		String sql = 
			"update employee " +
			"set " +
			"	empName='" + employee.getEmpName() + "', " +
			"	empAge= " + employee.getEmpAge() + ", " +
			"	empBtd = '" + dateStr + "', " +
			"	empSex = " + employee.getEmpSex() + 
			" where " +
			" empId = " + employee.getEmpId();
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;//总行数
		int pageCount = 0;//总页数
		String sql = "select count(*) from employee";
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

	public List<Employee> getNowPage(int nowPage, int pageSize) {
		List<Employee> emps = new Vector<Employee>();
		String sql = "select * from employee limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpAge(rs.getInt(3));
				emp.setEmpBtd(rs.getDate(4));
				emp.setEmpSex(rs.getInt(5));
				emp.setIsDelete(1);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return emps;
	}
}
