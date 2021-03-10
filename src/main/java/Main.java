import model.Bien;
import model.Emplacement;
import vue.LoginPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    static public void main(String[] args){

        ArrayList<Bien> listBiens = new ArrayList<Bien>();

        Date date =  new Date(2015, Calendar.MARCH,3);
        Emplacement emp = new Emplacement(1,"bureau du chef");
        Bien imprimente = new Bien(1,"imprimente", "B",date, "MATERIEL_INFORMATIQUUE",emp);

        listBiens.add(imprimente);
        listBiens.add(imprimente);
        listBiens.add(imprimente);
        listBiens.add(imprimente);




        SwingUtilities.invokeLater(() -> new LoginPage(listBiens).setVisible(true));
    }
}
