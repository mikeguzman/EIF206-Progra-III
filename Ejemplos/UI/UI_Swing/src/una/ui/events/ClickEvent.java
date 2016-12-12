/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ui.events;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mguzmana
 */
public class ClickEvent extends JFrame implements ActionListener {

    //https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
    
    JButton b1;
    JButton b2;
    JLabel lblText;

    public ClickEvent() {
        super("Click Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();

        b1 = new JButton("Name A");
        b2 = new JButton("Name B");
        lblText = new JLabel("My name is Mike");

        b1.addActionListener(this);
        b2.addActionListener(this);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);

        b1.setName("nameA");
        b2.setName("nameB");
        lblText.setName("result");

        add(b1);
        add(b2);
        add(lblText);

        pack();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1) {
            lblText.setText("My name is Mike");
        } else if (source == b2) {
            lblText.setText("My name is Juan");
        }
        repaint();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system "
                    + "look and feel: " + exc);
        }
    }

    public static void main(String[] arguments) {
        ClickEvent frame = new ClickEvent();
    }
}
