package main;

import gui.MainWindow;

import javax.swing.*;

/**
 * Created by cowlog on 18-1-4.
 * Serial key generator Main function
 */
public class SerialKeyGenerator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow ex = new MainWindow();
            ex.setVisible(true);
        });
    }
}
