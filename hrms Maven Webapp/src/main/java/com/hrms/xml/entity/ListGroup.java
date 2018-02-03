package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListGroup implements Serializable {

	private String id;
	private String name;
	private boolean selected;
	private List<Item> items;
	private boolean disabled = false;
	private String icon;
	
	public ListGroup() {
		items = new ArrayList<Item>();
	}
	public ListGroup(List<Item> items) {
		this.items = items;
	}
	
	public ListGroup(String id, String name, boolean selected,
			List<Item> items, boolean disabled, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.selected = selected;
		this.items = items;
		this.disabled = disabled;
		this.icon = icon;
	}
	public boolean addToItems(Item item){
		return items.add(item);
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
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "ListGroup [name=" + name +", id=" + id
				+ ", selected=" + selected + ", disabled=" + disabled
				+ ", items=" + items.size() + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<Item> its = new ArrayList<Item>();
		for (Item item : items) {
			its.add((Item)item.clone());
		}
		return new ListGroup(this.id,this.name,this.selected,its,this.disabled,this.icon);
	}
	
	/*public ListGroup clone(){
		return new ListGroup(new ArrayList<Item>(this.items));
	}*/
	
	
}
