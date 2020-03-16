package com.liujiadong.cms.bean;

import java.io.Serializable;

public class Channel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;//栏目名称
	private String description;//描述
	private String icon;//栏目图标
	private String sorted;//排序
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSorted() {
		return sorted;
	}
	public void setSorted(String sorted) {
		this.sorted = sorted;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + ", sorted="
				+ sorted + "]";
	}
	public Channel(Integer id, String name, String description, String icon, String sorted) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sorted = sorted;
	}
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
