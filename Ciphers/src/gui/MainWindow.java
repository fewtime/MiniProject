package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        this.init();
    }

    private void init() {
        setUIFont (new javax.swing.plaf.FontUIResource("Source Hans SC", Font.PLAIN,16));
        this.setTitle("Ciphers");

        JPanel panel = new JPanel();

        // Everything is added to the panel centered on the Y axis.
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Declare a textbox to put the original text and show the decrypted or encrypted text.
        final JTextArea textArea = new JTextArea(30, 40);
        textArea.setText("Enter the plain text or cipher text here.");
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        // Declare the detail of encryption's or decryption's info.
        final JTextField detailsField = new JTextField(40);
        detailsField.setText("Details about the encryption or decryption operation performed are outputted here.");
        detailsField.setEnabled(false);
        panel.add(detailsField);

        // Declare the button
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        final JButton encryptBtn = new JButton("Encrypt");
        final JButton decryptBtn = new JButton("Decrypt");
        final JButton clearBtn = new JButton("Clear");
        buttonPanel.add(encryptBtn);
        buttonPanel.add(decryptBtn);
        buttonPanel.add(clearBtn);
        panel.add(buttonPanel);

        // Display panel
        this.add(panel);

        // Display windows
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
