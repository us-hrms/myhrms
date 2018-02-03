package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hrms.xml.uitl.Dom4jUtil;

public class Navbar implements Serializable {
	private List<Nav> common;//������navbar����
	private Map<Long, List<Nav>> customizes;//����Ա����navbar
	private String filePath = Navbar.class.getClassLoader().getResource("com\\hrms\\xml\\entity\\navbar.xml").getPath();
	
	public Navbar() {
		this.common = new ArrayList<Nav>();
		this.customizes = new HashMap<Long, List<Nav>>();
	}

	public Navbar(List<Nav> common, Map<Long, List<Nav>> customizes) {
		super();
		this.common = common;
		this.customizes = customizes;
	}
	
	public static Navbar getNavbar(){
		return Dom4jUtil.readNavbar();
	}

	public List<Nav> getCommon() {
		return common;
	}

	public void setCommon(List<Nav> common) {
		this.common = common;
	}

	public Map<Long, List<Nav>> getCustomizes() {
		return this.customizes;
	}

	public void setCustomizes(Map<Long, List<Nav>> customizes) {
		this.customizes = customizes;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Navbar [common=" + common + ", customizes=" + customizes + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<Nav> comm = new ArrayList<Nav>(),temp;
		Map<Long, List<Nav>> cust = new HashMap<Long, List<Nav>>();
		//��¡������navbar
		comm = clone(common);
		//��¡�����û���navbar
		cust = clone(customizes);
		return new Navbar(comm,cust);
	}
	
	/**
	 * ��¡nav����
	 * @param original
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public List<Nav> clone(List<Nav> original) throws CloneNotSupportedException{
		List<Nav> comm = new ArrayList<Nav>();
		for (Nav nav : original) {
			comm.add((Nav)nav.clone());
		}
		return comm;
	}
	
	/**
	 * ��¡�û�map
	 * @param original
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Map<Long, List<Nav>> clone(Map<Long, List<Nav>> original) throws CloneNotSupportedException{
		List<Nav> temp;
		Map<Long, List<Nav>> cust = new HashMap<Long, List<Nav>>();
		for (Map.Entry<Long, List<Nav>> entry : customizes.entrySet()) {
			temp = new ArrayList<Nav>();
			for (Nav nav : entry.getValue()) {
				temp.add((Nav)nav.clone());
			}
			cust.put(entry.getKey(), temp);
		}
		return cust;
	}
	

	/**
	 * ���customizes�Ŀ�¡
	 * @return
	 */
	public Map<Long, List<Nav>> getCustomizesClone() {
		try {
			return clone(customizes);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����staff id
	 * ��¡Customize��Nav����
	 * @return
	 */
	public List<Nav> getCustomizeNavsClone(Long id){
		try {
			return clone(customizes.get(id));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Nav> getCommonAndCustomizeNavsClone(Long id){
		try {
			List<Nav> temp = clone(this.common);
			if(this.customizes.containsKey(id))
				temp.addAll(clone(customizes.get(id)));
			return temp;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���common�Ŀ�¡
	 * @return
	 */
	public List<Nav> getCommonClone() {
		try {
			return clone(common);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ӵ�����navbar
	 * @param nav
	 * @return
	 */
	public boolean addToCommon(Nav nav){
		return addToNavs(this.common, nav);
	}
	
	/**
	 * ��ӵ�List<Nav>����
	 * @return
	 */
	public boolean addToNavs(List<Nav> target,Nav nav){
		return target.add(nav);
	}
	
	/**
	 * ��ӵ�һ���û�map
	 * @param id
	 * @param navs
	 */
	public void putToCustomize(Long id,List<Nav> navs){
		//�����������id  ���¼ӵ�����
		if(!this.customizes.containsKey(id))
			this.customizes.put(id, navs);
		else//�����������ӵ�value�ļ�����
			for (Nav nav : navs) {
				addToCustomizeNavs(id,nav);
			}
	}

	/**
	 * ��ӵ�һ���û���nav������
	 * @param id
	 * @param nav
	 * @return
	 */
	public boolean addToCustomizeNavs(Long id,Nav nav){
		return this.customizes.get(id).add(nav);
	}
	
	/**
	 * ȥ��customize�ظ�������
	 */
	public void checkRepeat(){
		for (Long id : customizes.keySet()) {
			List<Nav> navs = customizes.get(id);
			List<String> navNames;
			List<Nav> newNavs = new ArrayList<Nav>();
			for (int i = 0; i < navs.size(); i++) {
				navNames = new ArrayList<String>();
				for (String name : navNames) {
					String temp = navs.get(i).getName();
					if(name.equals(temp))
						navNames.add(temp);
					else
						newNavs.add(navs.get(i));
				}
			}
			if(navs.size() > newNavs.size()){
				customizes.remove(id);
				customizes.put(id, newNavs);
			}
		}
	}
	
	public boolean isExists(Long id){
		return this.customizes.containsKey(id);
	}

	
}
