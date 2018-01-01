package FileEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class FileEditor extends JFrame {
    // File path text field
    private JTextField filePathField;

    // Edit text area
    private JTextArea editArea;

    // 'Save' button
    private JButton saveBtn;

    // 'Open' button
    private JButton openBtn;


    public FileEditor() {
        this.init();
    }

    private void init() {
        this.setTitle("Editor");

        // Component size
        this.setBounds(300, 50, 600, 650);

        // Create a north panel, to locale file
        filePathField = new JTextField(40);
        openBtn = new JButton("Browse");

        openBtn.addActionListener((ActionEvent actionEvent) ->
            openFile(filePathField.getText().replaceAll("//", "\\\\")));

        JPanel upPanel = new JPanel();
        upPanel.add(filePathField);
        upPanel.add(openBtn);

        this.add(upPanel, BorderLayout.NORTH);

        // Create a editor area, and add it to the center
        editArea = new JTextArea();
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        scrollPane.add(editArea);

        this.add(scrollPane);

        // Create a south panel, to save file
        saveBtn = new JButton("Save");

        JPanel southPanel = new JPanel();
        southPanel.add(saveBtn);
        this.add(southPanel, BorderLayout.SOUTH);

        // Display windows
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void openFile(String absolutePath) {
        File file = new File(absolutePath);

        if (!(file.exists())) {
            editArea.setText("File does NOT exist!");
        } else if (file.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String str;
                editArea.setText(null);
                while ((str = br.readLine()) != null) {
                    editArea.append(str + "\n");
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
