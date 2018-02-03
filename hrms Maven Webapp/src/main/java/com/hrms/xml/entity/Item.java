package com.hrms.xml.entity;

import java.io.Serializable;

public class Item implements Serializable {
	private String id;
	private String name;
	private String link;
	private boolean selected;
	private boolean disabled = false;
	
	
	public Item(String id, String name, String link, boolean selected,
			boolean disabled) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.selected = selected;
		this.disabled = disabled;
	}


	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	

	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", link=" + link + ", disabled=" + disabled
				+ ", selected=" + selected + "]";
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Item(this.id,this.name,this.link,this.selected,this.disabled);
	}
	
	
}
