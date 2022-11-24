package com.walangtech.exgui.app.event;

import com.walangtech.exgui.app.MainPanel;
import com.walangtech.exgui.app.MenuItem;

import java.awt.*;

public interface MenuEvent {
    void mainMenuSelected(MainPanel aPanel, int aIndex, MenuItem aMenuItem);
    void subMenuSelected(MainPanel aPanel, int aIndex, int aSubMenuIndex, Component aMenuItem);
}
