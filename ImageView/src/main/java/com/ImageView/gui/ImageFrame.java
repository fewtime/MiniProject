package com.ImageView.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by cowlog on 18-2-4.
 * Implement image frame.
 */
public class ImageFrame extends JFrame {
    private File imgFile;
    private BufferedImage img;

    public ImageFrame(File imgFile) {
        this.imgFile = imgFile;
        this.init();
    }

    private void init() {
        try {
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setSize(img.getWidth(), img.getHeight());
        this.getContentPane().add(new JLabel(new ImageIcon(img)));
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

