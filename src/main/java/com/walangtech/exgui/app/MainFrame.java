package com.walangtech.exgui.app;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.walangtech.exgui.app.event.MenuEvent;
import com.walangtech.exgui.app.view.DefaultView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

public class MainFrame extends JFrame {
    private Preferences root;
    private Preferences node;

    private JCheckBoxMenuItem chDarkMode;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JLabel lbLogo;
    private MainPanel mainPanel;
    private MenuItem mainMenuItem1;
    private MenuItem mainMenuItem2;
    private MenuItem mainMenuItem3;
    private MenuItem mainMenuItem4;
    private MenuItem mainMenuItem5;
    private Menu menu;
    private SubMenuPanel subMenu;

    public MainFrame(){
        root = Preferences.userRoot();
        node = root.node("com.walangtech.exgui.app");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);

        setLocation(left, top);

        init();
        menu.addEventMenuSelected(new MenuEvent() {
            @Override
            public void mainMenuSelected(MainPanel mainPanel, int index, MenuItem menuItem) {
            }

            @Override
            public void subMenuSelected(MainPanel mainPanel, int index, int subMenuIndex, Component menuItem) {
                mainPanel.displayForm(new DefaultView("Form " + index + "-" + subMenuIndex));
            }
        });
        menu.setSelectedIndex(0);

        pack();

    }

    private void init(){
        subMenu = new SubMenuPanel();
        menu = new Menu();
        lbLogo = new JLabel();
        mainMenuItem1 = new MenuItem();
        mainMenuItem3 = new MenuItem();
        mainMenuItem2 = new MenuItem();
        mainMenuItem4 = new MenuItem();
        mainMenuItem5 = new MenuItem();
        mainPanel = new MainPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        chDarkMode = new JCheckBoxMenuItem();


        subMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 1, 1, 1));

        menu.setMainPanel(mainPanel);
        menu.setSubMenuPanel(subMenu);

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        lbLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lbLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu.add(lbLogo);


        mainMenuItem1.setBackground(new java.awt.Color(255, 45, 185));
        mainMenuItem1.setForeground(new java.awt.Color(75, 0, 243));
        mainMenuItem1.setIcon(new ImageIcon(getClass().getResource("/icon/menu1.png"))); // NOI18N
        //mainMenuItem1.setText("Menu 1");
        mainMenuItem1.setMenuIcon(new AbstractListModel() {
            String[] strings = { "icon/s1_1.png", "icon/s1_2.png", "icon/s1_3.png", "icon/s1_4.png", "icon/s1_5.png", "icon/s1_6.png", "icon/s1_7.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mainMenuItem1.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Typography", "Buttons", "Cards", "Tabs", "Accordions", "Modals", "Lists & Media Object" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu.add(mainMenuItem1);


        mainMenuItem2.setBackground(new java.awt.Color(255, 0, 0));
        mainMenuItem2.setForeground(new java.awt.Color(241, 255, 0));
        mainMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu3.png"))); // NOI18N
        //mainMenuItem2.setText("Menu 2");
        mainMenuItem2.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "icon/s3_1.png", "icon/s3_2.png", "icon/s3_3.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mainMenuItem2.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Charts", "Morris", "Flot" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu.add(mainMenuItem2);


        mainMenuItem3.setBackground(new java.awt.Color(0, 217, 64));
        mainMenuItem3.setForeground(new java.awt.Color(74, 74, 74));
        mainMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu2.png"))); // NOI18N
        //mainMenuItem3.setText("Menu 3");
        mainMenuItem3.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "icon/s2_1.png", "icon/s2_2.png", "icon/s2_3.png", "icon/s2_4.png", "icon/s2_5.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mainMenuItem3.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Grid", "Progress Bars", "Notifications & Alerts", "Pagination", "Carousel" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu.add(mainMenuItem3);


        mainMenuItem4.setBackground(new java.awt.Color(8, 191, 196));
        mainMenuItem4.setForeground(new java.awt.Color(3, 66, 178));
        mainMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu4.png"))); // NOI18N
        //mainMenuItem4.setText("Menu 4");
        mainMenuItem4.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "icon/s4_1.png", "icon/s4_2.png", "icon/s4_3.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mainMenuItem4.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Maps", "Google Maps", "Vector Maps" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu.add(mainMenuItem4);


        mainMenuItem5.setBackground(new java.awt.Color(0, 225, 100));
        mainMenuItem5.setForeground(new java.awt.Color(178, 17, 225));
        mainMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu5.png"))); // NOI18N
        //mainMenuItem5.setText("Menu 5");
        menu.add(mainMenuItem5);


        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Options");

        chDarkMode.setText("Dark Mode");
        chDarkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chgDarkMode(evt);
            }
        });
        jMenu3.add(chDarkMode);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        buildLayout();

    }

    private void buildLayout(){

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                        .addComponent(subMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }

    private void chgDarkMode(ActionEvent aActionEvent){
        if (chDarkMode.isSelected()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatDarculaLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }

    }



}