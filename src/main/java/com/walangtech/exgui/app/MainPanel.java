package com.walangtech.exgui.app;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public static MainPanel mainPanel;

    public MainPanel(){
        setLayout(new BorderLayout());
        mainPanel = this;
    }

    public void displayForm(Component aComponent){
        if (mainPanel != null) {
            mainPanel.removeAll();
            mainPanel.add(aComponent);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    public static MainPanel getInstance(){
        return mainPanel;
    }

}
