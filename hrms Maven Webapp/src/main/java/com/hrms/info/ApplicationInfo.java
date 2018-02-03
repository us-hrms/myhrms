package com.hrms.info;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hrms.xml.entity.Company;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Navbar;

@Component
public class ApplicationInfo {
	
	private Map<Integer, Menu> menuMap;
	private Company company;
	private Navbar navbar;
	
	@PostConstruct
	public void initial(){
		this.menuMap = Menu.getRoleMenuMap();
		this.company = Company.getCompany();
		this.navbar = Navbar.getNavbar();
	}

	public Map<Integer, Menu> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<Integer, Menu> menuMap) {
		this.menuMap = menuMap;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}
}
