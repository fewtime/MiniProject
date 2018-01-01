package FileEditor;

import WordCount.WordCount;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;

public class FileEditor extends JFrame {
    // File path text field
    private JTextField filePathField;

    // Edit text area
    private JTextArea editArea;

    // 'Save' button
    private JButton saveBtn;

    // 'Open' button
    private JButton openBtn;

    // 'Count' button
    private JButton countBtn;

    // Count message area
    private JLabel countMsg;

    // 'Highlight' button
    private JButton hlBtn;

    // Cancel 'Highlight' button
    private JButton cancelHlBtn;

    // Highlight text field
    private JTextField hlField;

    public FileEditor() {
        this.init();
    }

    private void init() {
        setUIFont (new javax.swing.plaf.FontUIResource("Source Hans SC",Font.PLAIN,16));

        this.setTitle("Editor");

        // Component size
        this.setBounds(300, 50, 600, 650);

        // Create a north panel, to locale file
        filePathField = new JTextField(40);
        filePathField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    openFile(filePathField.getText().replaceAll("//", "\\\\"));
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }

        });

        openBtn = new JButton("Browse");

        openBtn.addActionListener((ActionEvent actionEvent) -> openFileDialog());

        hlField = new JTextField(40);

        hlBtn = new JButton("Highlight");
        hlBtn.addActionListener((ActionEvent actionEvent) -> {
            Highlighter highLighter = editArea.getHighlighter();
            DefaultHighlighter.DefaultHighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray);
            String content = editArea.getText();
            String keyWord = hlField.getText();
            int pos = 0;
            while ((pos = content.indexOf(keyWord, pos)) >= 0) {
                try {
                    highLighter.addHighlight(pos, pos + keyWord.length(), p);
                    pos += keyWord.length();
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelHlBtn = new JButton("Cancel highlight");
        cancelHlBtn.addActionListener((ActionEvent actionEvent) -> {
            Highlighter highlighter = editArea.getHighlighter();
            Highlighter.Highlight[] highlighters = highlighter.getHighlights();
            for (Highlighter.Highlight h : highlighters) {
                highlighter.removeHighlight(h);
            }
        });

        JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        upPanel.add(filePathField);
        upPanel.add(openBtn);
        upPanel.add(hlField);
        upPanel.add(hlBtn);
        upPanel.add(cancelHlBtn);

        this.add(upPanel, BorderLayout.NORTH);

        // Create a editor area, and add it to the center
        editArea = new JTextArea();
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        scrollPane.add(editArea);

        this.add(scrollPane);

        // Create a south panel, to save file and count characters.
        saveBtn = new JButton("Save");
        saveBtn.addActionListener((ActionEvent actionEvent) -> saveFile());

        countBtn = new JButton("Count");
        countMsg = new JLabel("");
        countBtn.addActionListener((ActionEvent actionEvent) -> {
            WordCount wd = new WordCount(editArea.getText());
            String info = "Count: Chinese: " + wd.getChCnt() + " English: " + wd.getEngCnt()
                    + " Number: " + wd.getNumCnt() + " Special: " + wd.getSpecCnt();
            countMsg.setText(info);
        });

        JPanel southPanel = new JPanel();
        southPanel.add(saveBtn);
        southPanel.add(countBtn);
        southPanel.add(countMsg);
        this.add(southPanel, BorderLayout.SOUTH);

        // Display windows
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void openFileDialog() {
        FileDialog fd = new FileDialog(this, "Open File");

        // Set the file suffix
        fd.setFile("untitled.txt");

        // Set "Load" model
        fd.setMode(FileDialog.LOAD);
        fd.setVisible(true);

        // Get file name
        String fileName = fd.getFile();

        // Get current directory
        String dir = fd.getDirectory();

        openFile(dir + File.separator + fileName);
    }

    private void saveFile() {
        String currentFilePath = filePathField.getText();
        String fileName = currentFilePath.substring(currentFilePath.lastIndexOf('/'), currentFilePath.length());
        String dir = currentFilePath.substring(0, currentFilePath.lastIndexOf('/'));
        FileDialog fd = new FileDialog(this, "Save File");

        // Set the file name and dir in file dialog
        fd.setDirectory(dir);
        fd.setFile(fileName);

        // Set "Save" model
        fd.setMode(FileDialog.SAVE);
        fd.setVisible(true);

        // Get file name
        fileName = fd.getFile();

        // Get current directory
        dir = fd.getDirectory();

        // Create a target file based on directory and file name
        File newFile = new File(dir + File.separator + fileName);
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newFile)))) {
            String str = editArea.getText();
            pw.println(str);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openFile(String absolutePath) {
        filePathField.setText(absolutePath);
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
