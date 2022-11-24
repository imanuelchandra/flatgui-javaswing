package com.walangtech.exgui.app.renderer;

import com.walangtech.exgui.app.Menu;
import com.walangtech.exgui.app.model.ModelSubMenu;

import java.awt.*;

public interface SubMenuItemRenderer {
    Component getSubMenuItemRenderer(Menu aMenu, ModelSubMenu aModel);
}
