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
public class FocusExample extends JFrame implements FocusListener {
    
    // https://docs.oracle.com/javase/8/docs/api/java/awt/event/FocusListener.html
    
    JTextField value1, value2, sum;
    JLabel plus, equals;

    public FocusExample() {
        super("Add Two Numbers");
        setSize(350, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
        // create components
        value1 = new JTextField("0", 5);
        value1.setName("value1");
        plus = new JLabel("+");
        value2 = new JTextField("0", 5);
        value2.setName("value2");
        equals = new JLabel("=");
        sum = new JTextField("0", 5);
        sum.setName("sum");
        // add listeners
        value1.addFocusListener(this);
        value2.addFocusListener(this);
        // set up sum field
        sum.setEditable(false);
        // add components
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(value1.getText()) +
                Float.parseFloat(value2.getText());
            sum.setText("" + total);
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    public void focusLost(FocusEvent event) {
        focusGained(event);
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
        FocusExample frame = new FocusExample();
    }
}