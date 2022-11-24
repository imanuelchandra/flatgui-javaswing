package com.walangtech.exgui.app;

import com.walangtech.exgui.app.animation.RippleEffect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MenuItem extends JButton {
    private ListModel<String> menuModel;
    private ListModel<String> menuIcon;
    private final RippleEffect rippleEffect = new RippleEffect(this);

    public MenuItem(){
        setContentAreaFilled(false);
        setBackground(new Color(200, 18, 124));
        setForeground(new Color(113, 73, 230));
        setIcon(new ImageIcon(getClass().getResource("/icon/menu.png")));

    }

    private void init(){
        Color color = UIManager.getColor("exgui.menu.ripplecolor");
        if (color != null) {
            rippleEffect.setRippleColor(color);
        } else {
            rippleEffect.setRippleColor(Color.WHITE);
        }
    }

    public ListModel<String> getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(ListModel<String> menuModel) {
        this.menuModel = menuModel;
    }

    public ListModel<String> getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(ListModel<String> menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (rippleEffect != null) {
            init();
        }
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        g2.setPaint(new GradientPaint(x, y, getBackground(), x + size, y + size, getForeground()));
        Shape shape = new Ellipse2D.Double(x, y, size, size);
        g2.fill(shape);
        rippleEffect.reder(g, shape);
        g2.dispose();
        super.paintComponent(g);
    }


}
