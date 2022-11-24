package com.walangtech.exgui.app;

import com.walangtech.exgui.app.animation.RippleEffect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SubMenuItem extends JButton {
    private final RippleEffect rippleEffect = new RippleEffect(this);

    public SubMenuItem(String aText){
        super(aText);
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        init();

    }

    private void init(){
        Color color = UIManager.getColor("exgui.submenu.ripplecolor");
        if (color != null) {
            rippleEffect.setRippleColor(color);
        } else {
            rippleEffect.setRippleColor(Color.WHITE);
        }

    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (rippleEffect != null) {
            init();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        rippleEffect.reder(g, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(g);
    }
}
