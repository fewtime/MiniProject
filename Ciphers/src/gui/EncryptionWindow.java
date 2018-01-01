package gui;

import ciphers.CaesarCipher;
import ciphers.Cipher;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by cowlog on 18-1-1.
 * Implement EncryptionWindow
 */

class EncryptionWindow extends JFrame {

    final private JTextArea textBox;
    final private JTextField detailsField;
    private String plainText;

    EncryptionWindow(JTextArea textBox, JTextField detailsField) {
        this.textBox = textBox;
        this.detailsField = detailsField;
        plainText = textBox.getText().trim().replaceAll("\\W", "");

        init();
    }

    private void init() {
        final JPanel panel = new JPanel();

        // Everything is added to the panel centered on the Y axis.
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the encryption protocol panel.
        final JPanel protocolPanel = new JPanel();
        protocolPanel.setLayout(new BoxLayout(protocolPanel, BoxLayout.X_AXIS));
        final JLabel protocolLabel = new JLabel("Encryption protocol: ");
        final String options[] = {
                "Casear Cipher", "Vernam Cipher", "Vigenere Cipher"
        };
        final JComboBox<String> protocolBox = new JComboBox<>(options);
        protocolPanel.add(protocolLabel);
        protocolPanel.add(protocolBox);
        panel.add(protocolPanel);

        // Create the key panel.
        final JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.X_AXIS));
        final JButton generateButton = new JButton("Generate Key");
        final JTextField keyField = new JTextField(30);
        keyField.setEditable(false);
        keyPanel.add(generateButton);
        keyPanel.add(keyField);
        panel.add(keyPanel);

        // Generate button's listener
        generateButton.addActionListener((ActionEvent actionEvent) -> {
            int chosenCipher = protocolBox.getSelectedIndex();
            Cipher cipher = (Cipher) Cipher.factory(chosenCipher, plainText.length());
            keyField.setText(cipher != null ? cipher.generateKey() : "NULL");
        });

        // Create 'Submit' button.
        final JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // 'Submit' button's listener.
        submitButton.addActionListener((ActionEvent actionEvent) -> {
            int chosenCipher = protocolBox.getSelectedIndex();
            String key = keyField.getText();
            Cipher cipher = (Cipher) Cipher.factory(chosenCipher, plainText.length());

            String cipherText = cipher != null ? cipher.encrypt(plainText, key) : null;
            textBox.setText(cipherText);
            detailsField.setText("Encrypted text using the " + (cipher != null ? cipher.getNAME() : null) +
                    " with key " + key);
            dispose();
        });

        // Display windows
        this.add(panel);
        this.pack();
        setTitle("Encryption");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
