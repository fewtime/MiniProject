package com.MusicPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Created by cowlog on 18-2-21.
 * Music player demo
 */
public class MusicPlayer extends Frame {

    private String filePath;
    private String fileName;

    private final List list;
    private final Label labelFilePath;
    private final Label labelFileName;

    private Player player;

    private MusicPlayer() {
        setLayout(new BorderLayout());
        setTitle("Music Player");
        setSize(350, 370);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuOpen = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
        menuFile.add(menuOpen);
        menuFile.addActionListener(actionEvent -> open());
        menuBar.add(menuFile);
        setMenuBar(menuBar);

        list = new List(10);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    fileName = list.getSelectedItem();
                    try {
                        play();
                    } catch (JavaLayerException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        add(list, "Center");
        
        Panel panel  =new Panel(new GridLayout(2, 1));
        labelFilePath = new Label("Path: ");
        labelFileName = new Label("File: ");
        panel.add(labelFileName);
        panel.add(labelFileName);
        add(panel, "North");
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }


    private void play() throws JavaLayerException, FileNotFoundException {
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(new File(filePath + fileName)));
        player = new Player(bufferedInputStream);
        player.play();
    }

    private void open() {
        FileDialog dialog = new FileDialog(this, "Open", 0);
        dialog.setVisible(true);
        filePath = dialog.getDirectory();
        if (filePath != null) {
            labelFilePath.setText("Path: " + filePath);

            list.removeAll();
            File fileDir = new File(filePath);
            File[] fileList = fileDir.listFiles();
            assert fileList != null;
            for (File file : fileList) {
                String fileName = file.getName().toLowerCase();
                if (fileName.endsWith(".mp3") || fileName.endsWith(".wav")) {
                    list.add(fileName);
                }
            }
        }
    }

    public static void main(String args[]) {
        new MusicPlayer();
    }
}
