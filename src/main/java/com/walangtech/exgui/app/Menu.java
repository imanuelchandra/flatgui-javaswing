package com.walangtech.exgui.app;

import com.walangtech.exgui.app.animation.MenuAnimation;
import com.walangtech.exgui.app.event.MenuEvent;
import com.walangtech.exgui.app.model.ModelSubMenu;
import com.walangtech.exgui.app.renderer.DefaultSubMenuItemRenderer;
import com.walangtech.exgui.app.renderer.SubMenuItemRenderer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Menu extends JComponent {
    private float opacity = 0.2f;
    private SubMenuPanel subMenuPanel;
    private MainPanel mainPanel;
    private SubMenuItemRenderer subMenuItemRender = new DefaultSubMenuItemRenderer();
    private MenuAnimation animator;
    private int selectedIndex = -1;
    private ArrayList<MenuEvent> events = new ArrayList<>();

    public Menu(){
        setLayout(new MigLayout("wrap, inset 10 5 80 5, fillx", "fill", "[]70[]20[]"));
        animator = new MenuAnimation(this);
        init();
    }

    public void init(){

        Color color = UIManager.getColor("exgui.menu.color");
        if (color != null) {
            setForeground(color);
        } else {
            setForeground(Color.WHITE);
        }
    }

    private Shape create() {
        int x = 2;
        int y = getMenuFirstItem() - 80;
        int width = getWidth();
        int space = 30;
        int lastItemLocation = getMenuItemLastLocation();
        GeneralPath p = new GeneralPath(new CubicCurve2D.Double(width, y, width, y + 50, x, y + space, x, y + 50 + space));
        p.lineTo(x, lastItemLocation);
        p.append(new CubicCurve2D.Double(x, lastItemLocation, x, lastItemLocation + 50, width, lastItemLocation + space, width, lastItemLocation + 50 + space), true);
        return p;
    }

    public void addEventMenuSelected(MenuEvent event) {
        events.add(event);
    }

    private void runEventMainMenu(int index, MenuItem menuItem) {
        for (MenuEvent event : events) {
            event.mainMenuSelected(mainPanel, index, menuItem);
        }
    }

    private void runEventSubMenu(int index, int subMenuIndex, Component subMenuItem) {
        for (MenuEvent event : events) {
            event.subMenuSelected(mainPanel, index, subMenuIndex, subMenuItem);
        }
    }

    private void applyEvent(Component com) {
        if (com instanceof JButton) {
            JButton cmd = (JButton) com;
            cmd.addActionListener(e -> {
                setSelectedIndex(getIndexOf(com));
            });
        }
    }

    public void setSelectedIndex(int index) {
        if (index >= 0 && selectedIndex != index) {
            if (subMenuPanel != null) {
                subMenuPanel.removeAll();
                Component com = getComponent(index + 1);
                if (com instanceof MenuItem) {
                    MenuItem item = (MenuItem) com;
                    ListModel model = item.getMenuModel();
                    ListModel icon = item.getMenuIcon();
                    if (model != null) {
                        for (int i = 0; i < model.getSize(); i++) {
                            ModelSubMenu data = new ModelSubMenu(getMenuIcon(icon, i), model.getElementAt(i).toString());
                            Component c = subMenuItemRender.getSubMenuItemRenderer(this, data);
                            if (c instanceof JButton) {
                                ((JButton) c).addActionListener((ActionEvent ae) -> {
                                    runEventSubMenu(getIndexOf(com), subMenuPanel.getComponentZOrder(c), c);
                                });
                            }
                            subMenuPanel.add(c);
                        }
                    }
                    selectedIndex = index;
                    runEventMainMenu(index, item);
                    animator.change(item);
                }
                subMenuPanel.revalidate();
                subMenuPanel.repaint();
            }

        }
    }

    private Icon getMenuIcon(ListModel<String> data, int index) {
        if (data != null && index < data.getSize()) {
            System.out.println("/"+data.getElementAt(index));
            return new ImageIcon(getClass().getResource("/"+data.getElementAt(index)));
        } else {
            return null;
        }
    }

    private int getMenuFirstItem() {
        for (Component com : getComponents()) {
            if (com instanceof JButton) {
                return com.getY();
            }
        }
        return 0;
    }

    private int getMenuItemLastLocation() {
        Component com = getComponent(getComponentCount() - 1);
        return com.getY() + com.getHeight();
    }

    private int getIndexOf(Component com) {
        return getComponentZOrder(com) - 1;
    }

    public SubMenuItemRenderer getSubMenuItemRender() {
        return subMenuItemRender;
    }

    public void setSubMenuItemRender(SubMenuItemRenderer subMenuItemRender) {
        this.subMenuItemRender = subMenuItemRender;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        init();
    }

    @Override
    public Component add(Component comp) {
        applyEvent(comp);
        return super.add(comp);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if (getComponentCount() > 1) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            g2.setColor(getForeground());
            g2.fill(create());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            float x = getWidth() - 3;
            float y = animator.getLocation();
            float height = animator.getItemSize();
            g2.setPaint(new GradientPaint(x, y, animator.getSelectedColor1(), x + 3, y + height, animator.getSelectedColor2()));
            g2.fill(new RoundRectangle2D.Double(x, y, 3, height, 5, 5));
            g2.dispose();
        }
        super.paintComponent(g);
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public SubMenuPanel getSubMenuPanel() {
        return subMenuPanel;
    }

    public void setSubMenuPanel(SubMenuPanel subMenuPanel) {
        this.subMenuPanel = subMenuPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
