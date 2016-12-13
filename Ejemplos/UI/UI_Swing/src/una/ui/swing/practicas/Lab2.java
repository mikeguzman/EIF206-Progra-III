/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ui.swing.practicas;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import una.ui.swing.frame.Authenticator;

/**
 *
 * @author mguzmana
 */
public class Lab2 extends JFrame {

    String[] genders = {"Masculino", "Femenino", "Otro"};

    JTextField name = new JTextField(20);
    JTextField phone = new JTextField(20);
    JComboBox gender = new JComboBox(genders);
    JTextArea result = new JTextArea(4, 20);
    JButton ok = new JButton("OK");
    JButton clean = new JButton("Clean");

    public Lab2() {
        super("Lab2 Information");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);

        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("Nombre: ");
        JLabel phoneLabel = new JLabel("Phone: ");
        JLabel genderLabel = new JLabel("Gender:                ");
        JLabel resultLabel = new JLabel("Result: ");

        //set the name to components
        panel.setName("Form");
        nameLabel.setName("lblName");
        phoneLabel.setName("lblPhone");
        genderLabel.setName("lblGender");
        resultLabel.setName("lblResult");

        name.setName("name");
        phone.setName("phone");
        gender.setName("gender");
        result.setName("comments");
        ok.setName("ok");
        clean.setName("clean");

        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        result.setEnabled(false);

        panel.setName("Form");
        panel.setLayout(lm);
        panel.add(nameLabel);
        panel.add(name);
        panel.add(phoneLabel);
        panel.add(phone);
        panel.add(genderLabel);
        panel.add(gender);
        panel.add(resultLabel);
        panel.add(result);
        panel.add(ok);
        panel.add(clean);
        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        Lab2.setLookAndFeel();
        Lab2 lab2 = new Lab2();
    }
}
