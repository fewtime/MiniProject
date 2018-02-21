package com.WebBrowser.gui;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by cowlog on 18-2-15.
 *  Web browser main window.
 */
public class MainWindow extends JFrame implements HyperlinkListener, PropertyChangeListener{
    /*  Swing */
    // HTML pane
    private JEditorPane textPane;
    // state line
    private JLabel messageLine;
    // url text box
    private JTextField urlField;

    // button
    private JButton backButton;
    private JButton forwardButton;

    // History list
    private java.util.List historyList = new ArrayList();
    // History index
    private int historyListIndex = -1;
    // MAX_HISTORY
    private static final int MAX_HISTORY = 50;

    // windows's count
    private static int numBrowserWindows = 0;
    // flag, determine whether exit the program while closing windows
    private static boolean exitWhenLastWindowClosed = false;

    // Homepage
    private String homePageURL = "http://www.baidu.com";

    public MainWindow() {
        this.init();
    }

    private void init() {
        setUIFont(new javax.swing.plaf.FontUIResource("Source Hans SC", Font.PLAIN,16));
        this.setTitle("Web Browser");

        // Set HTML pane cannot editable
        textPane = new JEditorPane();
        textPane.setEditable(false);

        // Register listener for hyperlink
        textPane.addHyperlinkListener(this);
        // Register listener for web page loading
        textPane.addPropertyChangeListener(this);

        // put HTML pane on the center
        this.getContentPane().add(
                new JScrollPane(textPane), BorderLayout.CENTER
        );

        // Create state line and put it under the window
        messageLine = new JLabel(" ");
        this.getContentPane().add(messageLine, BorderLayout.SOUTH);

        // Init menu and toolbar
        this.initMenu();
        this.initToolbar();

        MainWindow.numBrowserWindows++;

        // while closing window, call "close" method
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                close();
            }
        });
    }

    /**
      * Init toolbar
     */
    private void initToolbar() {
        // back button
        backButton = new JButton("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(actionEvent -> back());

        // forward button
        forwardButton = new JButton("Forward");
        forwardButton.setEnabled(false);
        forwardButton.addActionListener(actionEvent -> forward());

        // refresh button
        JButton refreshButton  = new JButton("Reload");
        refreshButton.addActionListener(actionEvent -> reload());

        // home button
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(actionEvent -> home());

        JToolBar toolBar = new JToolBar();
        toolBar.add(backButton);
        toolBar.add(forwardButton);
        toolBar.add(refreshButton);
        toolBar.add(homeButton);

        // URL text
        urlField = new JTextField();
        urlField.addActionListener(actionEvent -> displayPage(urlField.getText()));

        // Label
        toolBar.add(new JLabel("Address:"));
        toolBar.add(urlField);

        this.getContentPane().add(toolBar, BorderLayout.NORTH);
    }

// --Commented out by Inspection START (18-2-21 下午3:22):
//    public static void setExitWhenLastWindowClosed(boolean b) {
//        exitWhenLastWindowClosed = b;
//    }
// --Commented out by Inspection STOP (18-2-21 下午3:22)

// --Commented out by Inspection START (18-2-21 下午3:22):
//    public void setHomePageURL(String homePageURL) {
//        this.homePageURL = homePageURL;
//    }
// --Commented out by Inspection STOP (18-2-21 下午3:22)

    private boolean visit(URL url) {
        try {
            String href = url.toString();
            startAnimation("Loading" + href + "...");
            textPane.setPage(url);
            this.setTitle(href);
            urlField.setText(href);
            return true;
        } catch (IOException e) {
            stopAnimation();
            messageLine.setText("Cannot open: " + e.getMessage());
            return false;
        }
    }

    private void displayPage(URL url) {
        if (visit(url)) {
            //noinspection unchecked
            historyList.add(url);
            int numEntries = historyList.size();
            if (numEntries > MAX_HISTORY + 10) {
                historyList = historyList.subList(numEntries - MAX_HISTORY, numEntries);
                numEntries = MAX_HISTORY;
            }
            historyListIndex = numEntries - 1;
            if (historyListIndex > 0) {
                backButton.setEnabled(true);
            }
        }
    }

    private void displayPage(String href) {
        try {
            if (!href.startsWith("http://") && !href.startsWith("https://")){
                href = "http://" + href;
            }
            displayPage(new URL(href));
        } catch (MalformedURLException ex) {
            messageLine.setText("Wrong URL: " + href);
        }
    }

    private void back() {
        if (historyListIndex > 0){
            visit((URL)historyList.get(--historyListIndex));
        }
        backButton.setEnabled((historyListIndex > 0));
        forwardButton.setEnabled((historyListIndex < historyList.size()-1));
    }

    private void forward() {
        if (historyListIndex < historyList.size( )-1){
            visit((URL)historyList.get(++historyListIndex));
        }
        backButton.setEnabled((historyListIndex > 0));
        forwardButton.setEnabled((historyListIndex < historyList.size()-1));
    }

    private void reload() {
        if (historyListIndex != -1) {
            textPane.setDocument(new javax.swing.text.html.HTMLDocument());
            visit((URL)historyList.get(historyListIndex));
        }
    }

    private void home() {
        displayPage(getHome());
    }

    private String getHome() {
        return homePageURL;
    }

    private void newBrowser() {
        MainWindow b = new MainWindow();
        b.setSize(this.getWidth(), this.getHeight());
        b.setVisible(true);
    }

    private void close() {
        this.setVisible(false);
        this.dispose();
        synchronized(MainWindow.class) {
            MainWindow.numBrowserWindows--;
            if ((numBrowserWindows==0) && exitWhenLastWindowClosed){
                System.exit(0);
            }
        }
    }

    private void exit() {
        if ((JOptionPane.showConfirmDialog(this, "Are you sure to exit?", "Exit",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)){
            System.exit(0);
        }
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        HyperlinkEvent.EventType type = e.getEventType();
        if (type == HyperlinkEvent.EventType.ACTIVATED) {
            displayPage(e.getURL());
        }
        else if (type == HyperlinkEvent.EventType.ENTERED) {
            messageLine.setText(e.getURL().toString());
        }
        else if (type == HyperlinkEvent.EventType.EXITED) {
            messageLine.setText(" ");
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals("page")) {
            stopAnimation();
        }
    }

    private String animationMessage;
    private int animationFrame = 0;
    private final String[] animationFrames = new String[] {
            "-", "\\", "|", "/"
    };

    private final javax.swing.Timer animator =
            new javax.swing.Timer(125, e -> animate());

    private void animate() {
        String frame = animationFrames[animationFrame++];
        messageLine.setText(animationMessage + " " + frame);
        animationFrame = animationFrame % animationFrames.length;
    }

    private void startAnimation(String msg) {
        animationMessage = msg;
        animationFrame = 0;
        animator.start();
    }

    private void stopAnimation() {
        animator.stop();
        messageLine.setText(" ");
    }


    /**
     *Init menu
     */
    private void initMenu() {
        // File menu, including "create", "Open", "Close", "Exit"
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem createMenuItem = new JMenuItem("Create");
        createMenuItem.setMnemonic('N');
        // Binding a listener
        createMenuItem.addActionListener(actionEvent -> newBrowser());

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setMnemonic('O');
        // Binding a listener
        openMenuItem.addActionListener(actionEvent -> {
            // openLocalPage();
        });

        JMenuItem closeMenuItem = new JMenuItem("Close");
        closeMenuItem.setMnemonic('C');
        // Binding a listener
        closeMenuItem.addActionListener(actionEvent -> close());

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic('C');
        // Binding a listener
        exitMenuItem.addActionListener(actionEvent -> exit());

        fileMenu.add(createMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(closeMenuItem);
        fileMenu.add(exitMenuItem);

        // Helping menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic('A');
        helpMenu.add(aboutMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // set menu bar to main window
        this.setJMenuBar(menuBar);
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
