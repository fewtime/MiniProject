package com.ScreenShot.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by cowlog on 18-2-2.
 * Implement Screen frame.
 */

class ScreenFrame extends JFrame{
    private static final long serialVersionUID = 2L;
    private Dimension di = Toolkit.getDefaultToolkit().getScreenSize();

    ScreenFrame() {
        this.init();
    }

    /*
     * Create a full screen windows to capture.
     */

    private void init() {

        // set size
        this.setSize(di);
        // return a contentPane object
        getContentPane().add(new DrawRect());
    }

    class DrawRect extends JPanel implements MouseMotionListener, MouseListener {

        private static final long serialVersionUID = 3L;

        int sx, sy, ex, ey;
        BufferedImage image;
        boolean flag = true;

        DrawRect() {
            try {
                // Get the screen as an image.
                Robot robot = new Robot();
                image = robot.createScreenCapture(new Rectangle(0, 0, di.width, di.height));
            } catch (Exception e) {
                throw new RuntimeException("ERROR");
            }

            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        public void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, di.width, di.height, this);
            g.setColor(Color.red);
            if (sx < ex && sy < ey) {
                g.drawRect(sx, sy, ex - sx, ey - sy);
            } else {
                g.drawRect(ex, ey, sx - ex, sy - ey);
            }
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseEvent.BUTTON3) { // Right click to exit
                System.exit(0);
            } else if (mouseEvent.getClickCount() == 2) { // Double click to capture
                try {
                    cutScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void cutScreen() throws Exception {
            Robot robot = new Robot();
            BufferedImage getImage;
            if (sx < ex && sy < ey) {
                getImage = robot.createScreenCapture(new Rectangle(sx, sy, ex - sx, ey - sy));
            } else {
                getImage = robot.createScreenCapture(new Rectangle(ex, ey, sx - ex, sy - ey));
            }

            FileDialog fd = new FileDialog(new Frame(), "Save file");

            fd.setMode(FileDialog.SAVE);
            fd.setVisible(true);

            String fileName = fd.getFile();
            String dir = fd.getDirectory();

            File newFile = new File(dir + File.separator + fileName);

            ImageIO.write(getImage, "png", newFile);
            System.exit(0);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            if (flag) {
                sx = mouseEvent.getX();
                sy = mouseEvent.getY();
            }
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            flag = false;
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            ex = mouseEvent.getX();
            ey = mouseEvent.getY();
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }
    }
}
