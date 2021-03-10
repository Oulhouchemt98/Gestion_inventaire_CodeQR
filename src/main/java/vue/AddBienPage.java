package vue;

import model.Bien;
import model.Emplacement;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class AddBienPage extends JFrame implements ActionListener {

    JPanel panel;
    JLabel code_label, description_label, Etat_label,genre_label,emp_num_label,emp_nom_label,message;
    JTextField code_text,description_text,Etat_text,genre_text,emp_num_text,emp_nom_text;
    JButton submit;

    ArrayList<Bien> listBiens = new ArrayList<Bien>();

    public AddBienPage(ArrayList<Bien> listBiens) {
        this.listBiens = listBiens;
        // code Label
        code_label = new JLabel();
        code_label.setText("code :");
        code_text = new JTextField();

        // description label

        description_label = new JLabel();
        description_label.setText("description :");
        description_text = new JTextField();

        // Etat label

        Etat_label = new JLabel();
        Etat_label.setText("Etat :");
        Etat_text = new JTextField();



        // genre label

        genre_label = new JLabel();
        genre_label.setText("genre :");
        genre_text = new JTextField();

        // emp numero label

        emp_num_label = new JLabel();
        emp_num_label.setText("Emplacement numero:");
        emp_num_text = new JTextField();


        // emp nom label

        emp_nom_label = new JLabel();
        emp_nom_label.setText("Emplacement nom:");
        emp_nom_text = new JTextField();

        // Submit

        submit = new JButton("Ajouter Bien");

        panel = new JPanel(new GridLayout(8, 1));

        panel.add(code_label);
        panel.add(code_text);
        panel.add(description_label);
        panel.add(description_text);
        panel.add(Etat_label);
        panel.add(Etat_text);
        panel.add(genre_label);
        panel.add(genre_text);
        panel.add(emp_num_label);
        panel.add(emp_num_text);
        panel.add(emp_nom_label);
        panel.add(emp_nom_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);

        JLabel Welcom_message = new JLabel();
        Welcom_message.setText("Ajouter un bien");
        JPanel panelMessage = new JPanel();

        JButton buttonsave = new JButton("Retour");
        buttonsave.addActionListener(actionEvent -> {
            setVisible(false);
            new DashBoard(listBiens).setVisible(true);
        });

        JButton buttonok = new  JButton("Se Deconnecter");
        buttonok.addActionListener(actionEvent -> {
            setVisible(false);
            new LoginPage(listBiens).setVisible(true);
        });

        JPanel toolpane = new JPanel();
        toolpane.add(buttonsave);
        toolpane.add(buttonok);

        panelMessage.add(Welcom_message, BorderLayout.CENTER);

        add(panelMessage, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(toolpane, BorderLayout.SOUTH);


        setSize(800, 600);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String code = code_text.getText();
        String description = description_text.getText();
        String etat = Etat_text.getText();
        String genre = genre_text.getText();
        String emplacement_num = emp_num_text.getText();
        String emplacement_nom = emp_nom_text.getText();

        Date date =  new Date();

        Emplacement emp = new Emplacement(Integer.parseInt(emplacement_num),emplacement_nom);
        Bien bien = new Bien(Integer.parseInt(code),description, etat,date, genre,emp);

        listBiens.add(bien);

        setVisible(false);
        new DashBoard(listBiens).setVisible(true);

    }
}