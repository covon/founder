package com.founder.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理Entity
 */
public class MenuEntity extends BaseEntity {
    private String menuId;          //菜单ID
    private String parentMenuId;    //父菜单ID
    private Integer menuLvl;        //菜单层级
    private String menuName;        //显示名称
    private Integer showIndex;      //显示顺序
    private String showImg;         //显示图片
    private String  menuUrl;        //菜单URL
    private List<MenuEntity> menus = new ArrayList<MenuEntity>();   //子菜单集合

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Integer getMenuLvl() {
        return menuLvl;
    }

    public void setMenuLvl(Integer menuLvl) {
        this.menuLvl = menuLvl;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}
