/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ui.events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mguzmana
 */
public class KeyChecker extends JFrame {

    JLabel keyLabel = new JLabel("Hit any key");

    public KeyChecker() {
        super("Hit a Key");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyMonitor monitor = new KeyMonitor(this);
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.err.println("Couldn't use the system "
                    + "look and feel: " + exc);
        }
    }

    public static void main(String[] arguments) {
        KeyChecker.setLookAndFeel();
        new KeyChecker();
    }
}

class KeyMonitor extends KeyAdapter {

    KeyChecker display;

    KeyMonitor(KeyChecker display) {
        this.display = display;
    }

    public void keyTyped(KeyEvent event) {
        display.keyLabel.setText("" + event.getKeyChar());
        display.repaint();
    }
}
