package gui;

import generator.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by cowlog on 18-1-4.
 * Implement MainWindow
 */

public class MainWindow extends JFrame {
    public MainWindow() {
        this.init();
    }

    private void init() {
        setUIFont(new javax.swing.plaf.FontUIResource("Source Hans SC", Font.PLAIN,16));
        this.setTitle("Serial key generator");

        // Everything is added to the panel centered on the Y axis.
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Declare a text area to display serial keys.
        final JTextArea textArea = new JTextArea(1, 40);
        textArea.setText("Serial key is shown here.");
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Declare a 'Generate' button
        final JButton generateBtn = new JButton("Generate");
        panel.add(generateBtn);

        // Button listener
        generateBtn.addActionListener((ActionEvent actionEvent) -> {
            Generator generator = new Generator(5, 5);
            textArea.setText(generator.get());
        });


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
