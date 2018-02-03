package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hrms.xml.uitl.Dom4jUtil;

public class Navbar implements Serializable {
	private List<Nav> common;//公共的navbar导航
	private Map<Long, List<Nav>> customizes;//所有员工的navbar
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
		//克隆公共的navbar
		comm = clone(common);
		//克隆所有用户的navbar
		cust = clone(customizes);
		return new Navbar(comm,cust);
	}
	
	/**
	 * 克隆nav集合
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
	 * 克隆用户map
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
	 * 获得customizes的克隆
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
	 * 根据staff id
	 * 克隆Customize的Nav集合
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
	 * 获得common的克隆
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
	 * 添加到公共navbar
	 * @param nav
	 * @return
	 */
	public boolean addToCommon(Nav nav){
		return addToNavs(this.common, nav);
	}
	
	/**
	 * 添加到List<Nav>集合
	 * @return
	 */
	public boolean addToNavs(List<Nav> target,Nav nav){
		return target.add(nav);
	}
	
	/**
	 * 添加到一个用户map
	 * @param id
	 * @param navs
	 */
	public void putToCustomize(Long id,List<Nav> navs){
		//如果不包含此id  就新加到其中
		if(!this.customizes.containsKey(id))
			this.customizes.put(id, navs);
		else//如果包含就添加到value的集合中
			for (Nav nav : navs) {
				addToCustomizeNavs(id,nav);
			}
	}

	/**
	 * 添加到一个用户的nav集合中
	 * @param id
	 * @param nav
	 * @return
	 */
	public boolean addToCustomizeNavs(Long id,Nav nav){
		return this.customizes.get(id).add(nav);
	}
	
	/**
	 * 去掉customize重复的内容
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
