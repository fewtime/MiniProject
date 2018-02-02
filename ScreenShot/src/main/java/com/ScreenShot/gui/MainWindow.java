package com.ScreenShot.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cowlog on 18-2-2.
 */
public class MainWindow extends JFrame{
    public MainWindow() {
        this.init();
    }

    private void init() {
        setUIFont (new javax.swing.plaf.FontUIResource("Source Hans SC", Font.PLAIN,16));
        this.setTitle("ScreenShot");

        JPanel panel = new JPanel();

        final JButton button = new JButton("ScreenShot");
        panel.add(button);

        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private static void setUIFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}
