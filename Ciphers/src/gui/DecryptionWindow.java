package gui;

import javax.swing.*;


/**
 * Created by cowlog on 18-1-1.
 * Implement DecryptionWindow
 */

class DecryptionWindow extends JFrame {
    final private JTextArea textBox;
    final private JTextField detailField;

    DecryptionWindow(JTextArea textBox, JTextField detailField) {
        this.textBox = textBox;
        this.detailField = detailField;

        init();
    }

    private void init() {
        JPanel panel = new JPanel();

        // Everything is added to the panel centered on the Y axis.
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the decryption protocol panel.
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
        final JLabel keyLabel = new JLabel("Enter the key used to encrypt the ciphertext: ");
        final JTextField keyField = new JTextField(30);
        keyPanel.add(keyLabel);
        keyPanel.add(keyField);
        panel.add(keyPanel);

        // Create 'Submit' button.
        final JButton submitBtn = new JButton("Submit");
        panel.add(submitBtn);

        // Display windows
        this.add(panel);
        this.pack();
        this.setTitle("Decryption");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
