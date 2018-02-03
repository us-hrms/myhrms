package com.hrms.xml.uitl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.hrms.xml.entity.Company;
import com.hrms.xml.entity.Item;
import com.hrms.xml.entity.ListGroup;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Nav;
import com.hrms.xml.entity.Navbar;
import com.hrms.xml.entity.Role;
import com.hrms.xml.entity.RolePermissions;

public class Dom4jUtil {
	
	private static Menu MENU;
	private static Company COMPANY;
	private static RolePermissions ROLEPERMISSIONS;
	private static Navbar NAVBAR;
	
	/**
	 * 读取xml文件信息到Company对象
	 * @return
	 */
	public static Company readCompany(){
		//如果缓冲的Company 不为空则返回缓冲的对象
		if(COMPANY != null)
			return COMPANY.clone();
		Document doc;
		Company company = new Company();
		Class companyClass = company.getClass();
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(company.getFilepath());
			//获得根元素 即 company元素
			Element root = doc.getRootElement();
			//获得子元素 迭代器
			Iterator<Element> iterator = root.elementIterator();
			//循环取出子元素  即 property元素
			while(iterator.hasNext()){
				Element property = iterator.next();
				//获得listgroup相关属性
				Field compro = companyClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//设置可访问性
				compro.set(company, property.attributeValue("value"));//设置属性值
			}
			COMPANY = company.clone();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}
	
	/**
	 * 将company对象写入xml文件
	 * @param company
	 * @return
	 */
	public static boolean writeCompany(Company company){
		COMPANY = null;//删除缓存的Company对象
		Document doc;
		Class companyClass = company.getClass();
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(company.getFilepath());
			//获得根元素 即 company元素
			Element root = doc.getRootElement();
			//获得子元素 迭代器
			Iterator<Element> iterator = root.elementIterator();
			//循环取出子元素  即 property元素
			while(iterator.hasNext()){
				Element property = iterator.next();
				//获得Company相关属性
				Field compro = companyClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//设置可访问性
				property.attribute("value").setText(compro.get(company).toString());//保存
			}
			//将文件写入
			OutputFormat out = OutputFormat.createPrettyPrint();//获得输出流
			out.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileOutputStream(company.getFilepath()), out);//写入器
			writer.write(doc);
			writer.close();
			return true;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static Menu readMenu(){
		//如果缓冲的menu有值 返回缓存的值
		if(MENU != null)
			try {
				return (Menu)MENU.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Document doc;
		Menu menu = new Menu();
		/*获得类*/
		Class menuClass = Menu.class;
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(menu.getFilePath());
			//获得根元素 即 company元素
			Element root = doc.getRootElement();
			//获得子元素 listgroup 迭代器
			Iterator<Element> lgs = root.elementIterator();
			ListGroup lg;
			//循环取出子元素  即 listgroup元素
			while(lgs.hasNext()){
				//获得元素
				Element lgElement = lgs.next();
				lg = new ListGroup();//初始化对象
				full(lgElement,lg);//将元素属性值写入lg对象
				//获得子元素 item 迭代器
				Iterator<Element> items = lgElement.elementIterator();
				Item item;
				//迭代listgroup 子元素
				while(items.hasNext()){
					//获得元素
					Element itemElement = items.next();
					item = new Item();//初始化对象
					full(itemElement,item);//将元素属性值写入item对象
					lg.addToItems(item);//添加到lg的items集合
				}
				menu.addToListGroups(lg);//添加到menu的listgroups集合
			}
			MENU = (Menu)menu.clone();//缓存
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	
	/**
	 * 元素属性值填入方法
	 * 在对象属性名中找到与元素属性名相同的元素
	 * 并将元素属性值赋予该对象属性
	 * @param element
	 * @param entity
	 * @return
	 */
	private static <T> boolean full(Element element,T entity){
		Class entityClass = entity.getClass();
		//获得所有元素属性
		List<Attribute> attrs = element.attributes();
		try {
			//遍历属性
			for (Attribute attr : attrs) {
				//获取与元素属性相对应的对象属性
				Field entityPro = entityClass.getDeclaredField(attr.getName());
				entityPro.setAccessible(true);//设置可访问性
				Class type = entityPro.getType();
				if(type.equals(Boolean.class) || type.equals(boolean.class))
					entityPro.set(entity, Boolean.valueOf(attr.getText()));//赋值
				else if(type.equals(Integer.class)||type.equals(int.class))
					entityPro.set(entity, Integer.valueOf(attr.getText()));//赋值
				else if(type.equals(Long.class)||type.equals(long.class))
					entityPro.set(entity, Long.valueOf(attr.getText()));//赋值
				else
					entityPro.set(entity, attr.getText());//赋值
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获得角色权限信息
	 * @return
	 */
	public static RolePermissions readRolePermissions(){
		if(ROLEPERMISSIONS != null)
			try {
				return (RolePermissions)ROLEPERMISSIONS.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Document doc;
		RolePermissions rp = new RolePermissions();
		Class companyClass = rp.getClass();
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(rp.getFilePath());
			//获得根元素 即 company元素
			Element root = doc.getRootElement();
			//获得子元素 迭代器
			Iterator<Element> roleList = root.elementIterator();
			Role role;
			//循环取出子元素  即 role元素
			while(roleList.hasNext()){
				//获得元素
				Element roleElement = roleList.next();
				role = new Role();
				//填入元素属性到对象相应的属性
				full(roleElement,role);
				//获得role元素的子元素集合
				List<Element> disables = roleElement.elements();
				//创建不可操作id的数组 大小为子元素集合的大小
				String [] ids = new String[disables.size()];
				//遍历子元素取出id
				for (int i = 0; i < ids.length; i++) {
					ids[i] = disables.get(i).attributeValue("id");
				}
				role.setDisabledIds(ids);
				rp.addToRoles(role);
			}
			ROLEPERMISSIONS = (RolePermissions)rp.clone();//缓存RolePermissions对象
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rp;
	}
	
	public static boolean writeRolePermissions(RolePermissions rp){
		ROLEPERMISSIONS = null;//删除缓存的RolePermissions对象
		Document doc;
		Class rpClass = rp.getClass();
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(rp.getFilePath());
			//获得根元素 即 company元素
			Element root = doc.getRootElement();
			//获得子元素 迭代器
			Iterator<Element> iterator = root.elementIterator();
			//循环取出子元素  即 property元素
			while(iterator.hasNext()){
				Element property = iterator.next();
				//获得Company相关属性
				Field compro = rpClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//设置可访问性
				property.attribute("value").setText(compro.get(rp).toString());//保存
			}
			//将文件写入
			OutputFormat out = OutputFormat.createPrettyPrint();//获得输出流
			out.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileOutputStream(rp.getFilePath()), out);//写入器
			writer.write(doc);
			writer.close();
			return true;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static Navbar readNavbar(){
		//如果缓冲的menu有值 返回缓存的值
		if(NAVBAR != null)
			try {
				return (Navbar)NAVBAR.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Document doc;
		Navbar navbar = new Navbar();
		/*获得类*/
		Class menuClass = Menu.class;
		try {
			//SAXReader 读取文件 返回Document对象  可能会有异常
			doc = new SAXReader().read(navbar.getFilePath());
			//获得根元素 即 navbars元素
			Element root = doc.getRootElement();
			//获得子元素 commone 或者  customizes 迭代器
			Iterator<Element> items = root.elementIterator();
			while (items.hasNext()) {
				//获得子元素
				Element element = items.next();
				Nav nav = null;
				//判断是哪个元素
				if(element.getName().equals("commone")){
					//获得nav的迭代器
					Iterator<Element> navsElement = element.elementIterator();
					//迭代nav元素集合
					while (navsElement.hasNext()) {
						Element navElement = navsElement.next();
						nav =new Nav();
						full(navElement,nav);
						navbar.addToCommon(nav);
					}
				}else if(element.getName().equals("customizes")){
					Iterator<Element> custsElement = element.elementIterator();
					//迭代customize集合
					while (custsElement.hasNext()) {
						Element custElement = custsElement.next();
						Iterator<Element> navsElement = custElement.elementIterator();
						Long custId = Long.valueOf(custElement.attributeValue("id"));//获得customize的id
						//放入customize 的map中
						navbar.putToCustomize(custId, new ArrayList<Nav>());
						//迭代nav集合
						while (navsElement.hasNext()) {
							Element navElement = navsElement.next();
							nav =new Nav();
							full(navElement,nav);
							//放入map里相应的id的nav集合中
							navbar.addToCustomizeNavs(custId, nav);
						}
					}
				}
			}
			NAVBAR = (Navbar)navbar.clone();//缓存
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navbar;
	}
	
}
