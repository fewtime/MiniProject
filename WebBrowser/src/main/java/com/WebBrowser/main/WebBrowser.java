package com.WebBrowser.main;

import com.WebBrowser.gui.MainWindow;

import javax.swing.*;

/**
 * Created by cowlog on 18-2-15.
 * Demo
 */
public class WebBrowser {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow ex = new MainWindow();
            ex.setVisible(true);
        });
    }
}
