package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Role implements Serializable {
	private Integer id;//��ɫId
	private String[] disabledIds;//���ɲ�����ѡ��id
	
	
	
	public Role(Integer id, String[] disabledIds) {
		super();
		this.id = id;
		this.disabledIds = disabledIds;
	}



	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String[] getDisabledIds() {
		return disabledIds;
	}



	public void setDisabledIds(String[] disabledIds) {
		this.disabledIds = disabledIds;
	}



	@Override
	public String toString() {
		return "Role [id=" + id + ", disabledIds=" + Arrays.toString(disabledIds)
				+ "]";
	}
	
	/**
	 * ����id���Role����
	 * @param id
	 * @return
	 */
	public static Role getRole(Integer id){
		for (Role role : RolePermissions.getRolePermissions().getRoles()) {
			if(role.getId().equals(id))
				return role;
		}
		return null;
	}



	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Role(this.id,this.disabledIds.clone());
	}



	
}
