package com.walangtech.exgui.app;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class ExMain {
    public static void main(String[] args){

        try {
            FlatLaf.registerCustomDefaultsSource( "com.walangtech.exgui.app" );
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() ->
        {
            var frame = new MainFrame();
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
