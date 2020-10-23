package com.founder.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName MenuNodeEntity
 * @Description TODO
 * @author WangBo
 * @date 2016年9月6日
 */
public class MenuNodeEntity implements Serializable{

	private static final long serialVersionUID = 3024616090269950394L;
	private String menuid;
	private String name;
	private String url;
	private String img;
	private boolean hasChild;
	private List<MenuNodeEntity> CNodes;
	
	public MenuNodeEntity(){}

	public MenuNodeEntity(String menuid, String name, String url, String img, boolean hasChild) {
		this.menuid = menuid;
		this.name = name;
		this.url = url;
		this.img = img;
		this.hasChild = hasChild;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public List<MenuNodeEntity> getCNodes() {
		return CNodes;
	}
	public void setCNodes(List<MenuNodeEntity> cNodes) {
		CNodes = cNodes;
	}
}
