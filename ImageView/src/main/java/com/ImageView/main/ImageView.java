package com.ImageView.main;

import com.ImageView.gui.ImageFrame;

import java.io.File;
import java.util.Scanner;

/**
 * Created by cowlog on 18-2-4.
 * Implement a demo.
 */
public class ImageView {
    public static void main(String[] args) {
        System.out.println("Input an image file path: ");
        Scanner sc = new Scanner(System.in);
        File imgFile = new File(sc.nextLine());
        ImageFrame imageFrame = new ImageFrame(imgFile);
    }
}
