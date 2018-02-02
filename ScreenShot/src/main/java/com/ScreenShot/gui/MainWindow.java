package com.ScreenShot.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by cowlog on 18-2-2.
 * Implement Main window gui
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
        final JTextArea textArea = new JTextArea("Double click to save, right click to quit");
        panel.add(textArea);

        button.addActionListener((ActionEvent actionEvent) -> {
            ScreenFrame sf = new ScreenFrame();
            sf.setVisible(true);
        });

        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

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
