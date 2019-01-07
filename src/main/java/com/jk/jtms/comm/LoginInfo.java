package com.jk.jtms.comm;

import java.util.List;

/**
 * @Package com.bm.jx.pojo.comm
 * @Title: LoginInfo.java
 * @Description: 登录信息
 * @author steven
 * @date 2018年8月15日 上午11:05:59
 * @version V1.0
 */
public class LoginInfo {
	/**
	 * 用戶id
	 */
	private String id;
	/**
	 * 用戶名
	 */
	private String userName;
	/**
	 * 用戶名稱
	 */
	private String name;
	/**
	 * 法院级别
	 */
	private Integer fyjb;

	/**
	 * 法院代码
	 */
	private String fydm;
	/**
	 * 法院名稱
	 */
	private String fymc;
	/**
	 * 角色
	 */
	private String role;

	/**
	 * 用户部门id
	 */
	private String departmentId;

	/**
	 * 用户的地区代码
	 */
	private String dqdm;
	/**
	 * 角色id的集合
	 */
	private List<String> roleIdList;


	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFyjb() {
		return fyjb;
	}

	public void setFyjb(Integer fyjb) {
		this.fyjb = fyjb;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFydm() {
		return fydm;
	}

	public void setFydm(String fydm) {
		this.fydm = fydm;
	}

	public String getDqdm() {
		return dqdm;
	}

	public void setDqdm(String dqdm) {
		this.dqdm = dqdm;
	}

	@Override
	public String toString() {
		return "LoginInfo{" + "id='" + id + '\'' + ", userName='" + userName + '\'' + ", name='" + name + '\''
				+ ", fyjb=" + fyjb + ", fydm='" + fydm + '\'' + ", fymc='" + fymc + '\'' + ", role='" + role + '\''
				+ ", departmentId='" + departmentId + '\'' + '}';
	}

}
