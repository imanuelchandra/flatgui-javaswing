package com.walangtech.exgui.app;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SubMenuPanel extends JComponent {
    private int round = 10;
    private float opacity = 0.15f;

    public SubMenuPanel(){
        setLayout(new MigLayout("wrap, inset 0, gap 0, fillx", "fill", "[fill, 35, shrink 0]"));
        init();
    }

    private void init(){
        Color color = UIManager.getColor("exgui.submenu.color");
        if (color != null) {
            setBackground(color);
        } else {
            setBackground(Color.WHITE);
        }
    }

    @Override
    public void updateUI() {
        super.updateUI();
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), round, round));
        g2.dispose();
        super.paintComponent(g);
    }
}
