package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hrms.xml.uitl.Dom4jUtil;

public class RolePermissions implements Serializable {
	
	private String filePath = this.getClass().getClassLoader().getResource("com\\hrms\\xml\\entity\\rolePermissions.xml").getPath();
	private List<Role> roles = new ArrayList<Role>();
	
	
	public RolePermissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RolePermissions(List<Role> roles) {
		this.roles = roles;
	}
	
	/**
	 * 获得RolePermissions对象
	 * @return
	 */
	public static RolePermissions getRolePermissions(){
		return Dom4jUtil.readRolePermissions();
	}


	/**
	 * 添加到roles
	 * @param role
	 * @return
	 */
	public boolean addToRoles(Role role){
		return roles.add(role);
	}

	@Override
	public String toString() {
		return "RolePermissions [roles=" + roles + "]";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<Role> rs = new ArrayList<Role>();
		for (Role role : roles) {
			rs.add((Role)role.clone());
		}
		return new RolePermissions(rs);
	}
	
	/*public RolePermissions clone(){
		return new RolePermissions(new ArrayList<Role>(this.roles));
	}*/
	
	
}
