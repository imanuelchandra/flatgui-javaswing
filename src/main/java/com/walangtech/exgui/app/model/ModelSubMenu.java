package com.walangtech.exgui.app.model;

import javax.swing.*;

public class ModelSubMenu {
    private Icon icon;
    private String name;

    public ModelSubMenu(){

    }

    public ModelSubMenu(Icon aIcon, String aName){
        icon = aIcon;
        name = aName;

    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
