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
	 * ��ȡxml�ļ���Ϣ��Company����
	 * @return
	 */
	public static Company readCompany(){
		//��������Company ��Ϊ���򷵻ػ���Ķ���
		if(COMPANY != null)
			return COMPANY.clone();
		Document doc;
		Company company = new Company();
		Class companyClass = company.getClass();
		try {
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(company.getFilepath());
			//��ø�Ԫ�� �� companyԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� ������
			Iterator<Element> iterator = root.elementIterator();
			//ѭ��ȡ����Ԫ��  �� propertyԪ��
			while(iterator.hasNext()){
				Element property = iterator.next();
				//���listgroup�������
				Field compro = companyClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//���ÿɷ�����
				compro.set(company, property.attributeValue("value"));//��������ֵ
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
	 * ��company����д��xml�ļ�
	 * @param company
	 * @return
	 */
	public static boolean writeCompany(Company company){
		COMPANY = null;//ɾ�������Company����
		Document doc;
		Class companyClass = company.getClass();
		try {
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(company.getFilepath());
			//��ø�Ԫ�� �� companyԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� ������
			Iterator<Element> iterator = root.elementIterator();
			//ѭ��ȡ����Ԫ��  �� propertyԪ��
			while(iterator.hasNext()){
				Element property = iterator.next();
				//���Company�������
				Field compro = companyClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//���ÿɷ�����
				property.attribute("value").setText(compro.get(company).toString());//����
			}
			//���ļ�д��
			OutputFormat out = OutputFormat.createPrettyPrint();//��������
			out.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileOutputStream(company.getFilepath()), out);//д����
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
		//��������menu��ֵ ���ػ����ֵ
		if(MENU != null)
			try {
				return (Menu)MENU.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Document doc;
		Menu menu = new Menu();
		/*�����*/
		Class menuClass = Menu.class;
		try {
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(menu.getFilePath());
			//��ø�Ԫ�� �� companyԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� listgroup ������
			Iterator<Element> lgs = root.elementIterator();
			ListGroup lg;
			//ѭ��ȡ����Ԫ��  �� listgroupԪ��
			while(lgs.hasNext()){
				//���Ԫ��
				Element lgElement = lgs.next();
				lg = new ListGroup();//��ʼ������
				full(lgElement,lg);//��Ԫ������ֵд��lg����
				//�����Ԫ�� item ������
				Iterator<Element> items = lgElement.elementIterator();
				Item item;
				//����listgroup ��Ԫ��
				while(items.hasNext()){
					//���Ԫ��
					Element itemElement = items.next();
					item = new Item();//��ʼ������
					full(itemElement,item);//��Ԫ������ֵд��item����
					lg.addToItems(item);//��ӵ�lg��items����
				}
				menu.addToListGroups(lg);//��ӵ�menu��listgroups����
			}
			MENU = (Menu)menu.clone();//����
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
	 * Ԫ������ֵ���뷽��
	 * �ڶ������������ҵ���Ԫ����������ͬ��Ԫ��
	 * ����Ԫ������ֵ����ö�������
	 * @param element
	 * @param entity
	 * @return
	 */
	private static <T> boolean full(Element element,T entity){
		Class entityClass = entity.getClass();
		//�������Ԫ������
		List<Attribute> attrs = element.attributes();
		try {
			//��������
			for (Attribute attr : attrs) {
				//��ȡ��Ԫ���������Ӧ�Ķ�������
				Field entityPro = entityClass.getDeclaredField(attr.getName());
				entityPro.setAccessible(true);//���ÿɷ�����
				Class type = entityPro.getType();
				if(type.equals(Boolean.class) || type.equals(boolean.class))
					entityPro.set(entity, Boolean.valueOf(attr.getText()));//��ֵ
				else if(type.equals(Integer.class)||type.equals(int.class))
					entityPro.set(entity, Integer.valueOf(attr.getText()));//��ֵ
				else if(type.equals(Long.class)||type.equals(long.class))
					entityPro.set(entity, Long.valueOf(attr.getText()));//��ֵ
				else
					entityPro.set(entity, attr.getText());//��ֵ
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
	 * ��ý�ɫȨ����Ϣ
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
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(rp.getFilePath());
			//��ø�Ԫ�� �� companyԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� ������
			Iterator<Element> roleList = root.elementIterator();
			Role role;
			//ѭ��ȡ����Ԫ��  �� roleԪ��
			while(roleList.hasNext()){
				//���Ԫ��
				Element roleElement = roleList.next();
				role = new Role();
				//����Ԫ�����Ե�������Ӧ������
				full(roleElement,role);
				//���roleԪ�ص���Ԫ�ؼ���
				List<Element> disables = roleElement.elements();
				//�������ɲ���id������ ��СΪ��Ԫ�ؼ��ϵĴ�С
				String [] ids = new String[disables.size()];
				//������Ԫ��ȡ��id
				for (int i = 0; i < ids.length; i++) {
					ids[i] = disables.get(i).attributeValue("id");
				}
				role.setDisabledIds(ids);
				rp.addToRoles(role);
			}
			ROLEPERMISSIONS = (RolePermissions)rp.clone();//����RolePermissions����
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
		ROLEPERMISSIONS = null;//ɾ�������RolePermissions����
		Document doc;
		Class rpClass = rp.getClass();
		try {
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(rp.getFilePath());
			//��ø�Ԫ�� �� companyԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� ������
			Iterator<Element> iterator = root.elementIterator();
			//ѭ��ȡ����Ԫ��  �� propertyԪ��
			while(iterator.hasNext()){
				Element property = iterator.next();
				//���Company�������
				Field compro = rpClass.getDeclaredField(property.attributeValue("name"));
				compro.setAccessible(true);//���ÿɷ�����
				property.attribute("value").setText(compro.get(rp).toString());//����
			}
			//���ļ�д��
			OutputFormat out = OutputFormat.createPrettyPrint();//��������
			out.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileOutputStream(rp.getFilePath()), out);//д����
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
		//��������menu��ֵ ���ػ����ֵ
		if(NAVBAR != null)
			try {
				return (Navbar)NAVBAR.clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		Document doc;
		Navbar navbar = new Navbar();
		/*�����*/
		Class menuClass = Menu.class;
		try {
			//SAXReader ��ȡ�ļ� ����Document����  ���ܻ����쳣
			doc = new SAXReader().read(navbar.getFilePath());
			//��ø�Ԫ�� �� navbarsԪ��
			Element root = doc.getRootElement();
			//�����Ԫ�� commone ����  customizes ������
			Iterator<Element> items = root.elementIterator();
			while (items.hasNext()) {
				//�����Ԫ��
				Element element = items.next();
				Nav nav = null;
				//�ж����ĸ�Ԫ��
				if(element.getName().equals("commone")){
					//���nav�ĵ�����
					Iterator<Element> navsElement = element.elementIterator();
					//����navԪ�ؼ���
					while (navsElement.hasNext()) {
						Element navElement = navsElement.next();
						nav =new Nav();
						full(navElement,nav);
						navbar.addToCommon(nav);
					}
				}else if(element.getName().equals("customizes")){
					Iterator<Element> custsElement = element.elementIterator();
					//����customize����
					while (custsElement.hasNext()) {
						Element custElement = custsElement.next();
						Iterator<Element> navsElement = custElement.elementIterator();
						Long custId = Long.valueOf(custElement.attributeValue("id"));//���customize��id
						//����customize ��map��
						navbar.putToCustomize(custId, new ArrayList<Nav>());
						//����nav����
						while (navsElement.hasNext()) {
							Element navElement = navsElement.next();
							nav =new Nav();
							full(navElement,nav);
							//����map����Ӧ��id��nav������
							navbar.addToCustomizeNavs(custId, nav);
						}
					}
				}
			}
			NAVBAR = (Navbar)navbar.clone();//����
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
