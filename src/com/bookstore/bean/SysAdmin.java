package com.bookstore.bean;
//管理员表
public class SysAdmin {
	//属性
	private int adminId;//管理员编号
	private String adminName;//管理员姓名
	private String pwd;//管理员密码
	private int adminType;//管理员级别
	
	//方法
	public SysAdmin() {
		
	}
	
	public SysAdmin(int adminId, String adminName, String pwd, int adminType) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.pwd = pwd;
		this.adminType = adminType;
	}

	@Override
	public String toString() {
		return "SysAdmin [adminId=" + adminId + ", adminName=" + adminName
				+ ", pwd=" + pwd + ", adminType=" + adminType + "]";
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + adminType;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysAdmin other = (SysAdmin) obj;
		if (adminId != other.adminId)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminType != other.adminType)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
}
