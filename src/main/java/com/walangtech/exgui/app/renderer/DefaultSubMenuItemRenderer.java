package com.walangtech.exgui.app.renderer;

import com.walangtech.exgui.app.Menu;
import com.walangtech.exgui.app.SubMenuItem;
import com.walangtech.exgui.app.model.ModelSubMenu;

import java.awt.*;

public class DefaultSubMenuItemRenderer implements SubMenuItemRenderer{
    @Override
    public Component getSubMenuItemRenderer(Menu aMenu, ModelSubMenu aModel) {
        SubMenuItem item = new SubMenuItem(aModel.getName());
        if (aModel.getIcon() != null) {
            item.setIcon(aModel.getIcon());
        }
        return item;
    }
}
