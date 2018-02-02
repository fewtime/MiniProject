package com.ScreenShot.main;

import com.ScreenShot.gui.MainWindow;

import javax.swing.*;

/**
 * Created by cowlog on 18-2-2.
 */
public class ScreenShot {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow ex = new MainWindow();
            ex.setVisible(true);
        });
    }
}
