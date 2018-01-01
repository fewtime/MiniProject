package main;

import gui.MainWindow;

import javax.swing.*;

/**
 * Created by cowlog on 18-1-1.
 * Ciphers Main function
 */
public class Ciphers {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow ex = new MainWindow();
            ex.setVisible(true);
        });
    }
}
