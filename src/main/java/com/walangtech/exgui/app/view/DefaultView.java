package com.walangtech.exgui.app.view;

import javax.swing.*;

public class DefaultView extends JPanel {
    private javax.swing.ButtonGroup groupGender;
    private javax.swing.JLabel lb;

    public DefaultView(String form) {
        init();
        lb.setText(form);
    }

    private void init(){
        groupGender = new javax.swing.ButtonGroup();
        lb = new javax.swing.JLabel();

        lb.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Form 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                                .addContainerGap())
        );

    }
}
