package vue;

import model.Bien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit;

    ArrayList<Bien> listBiens;

    public LoginPage(ArrayList<Bien> listBiens) {
        this.listBiens = listBiens;

        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);

        JLabel Welcom_message = new JLabel();
        Welcom_message.setText("Welcom connectez-vous!");
        JPanel panelMessage = new JPanel();
        panelMessage.add(Welcom_message, BorderLayout.CENTER);

        add(panelMessage, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setSize(800, 600);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (userName.trim().equals("zoubair") && password.trim().equals("azerty")) {
            setVisible(false);
            new DashBoard(listBiens).setVisible(true);
        } else {
            message.setText(" Invalid user.. ");
        }

    }

}