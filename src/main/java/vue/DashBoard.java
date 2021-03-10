package vue;

import com.google.zxing.WriterException;
import model.Bien;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class DashBoard extends JFrame
{
    public DashBoard(ArrayList<Bien> listBiens)
    {
        //headers for the table
        String[] columns = new String[] {
                "Code", "Description", "Etat", "Date", "genre","emp num", "emp nom"
        };


        //actual data for the table in a 2d array
        Object[][] data = new Object[listBiens.size()][7];
        int i=0;
        for(Bien b : listBiens){
            data[i] = new Object[]{b.code,b.description,b.Etat,b.date,b.genre,b.emp.numSalle,b.emp.nomsalle};
            i++;
        }
        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JButton buttondelete = new JButton("Supprimer Bien");
        buttondelete.addActionListener(actionEvent -> {
            int index = table.getSelectedRow();

            if(index != -1){
                listBiens.remove(index);
                int a=0;
                for(Bien b : listBiens){
                    data[a] = new Object[]{b.code,b.description,b.Etat,b.date,b.genre,b.emp.numSalle,b.emp.nomsalle};
                    a++;
                }

                this.setVisible(false);
                new DashBoard(listBiens);
            }
        });


        JButton buttonCodeQR = new JButton("Genere Code");
        buttonCodeQR.addActionListener(actionEvent -> {
            int index = table.getSelectedRow();

            if(index != -1) {
                setVisible(false);
                try {
                    new CodeQR(listBiens,index).setVisible(true);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });


        JButton buttonsave = new JButton("Ajouter Bien");
        buttonsave.addActionListener(actionEvent -> {
            setVisible(false);
            new AddBienPage(listBiens).setVisible(true);
        });

        JButton buttonok = new  JButton("Se Deconnecter");
        buttonok.addActionListener(actionEvent -> {
            setVisible(false);
            new LoginPage(listBiens).setVisible(true);
        });

        JPanel toolpane = new JPanel();
        toolpane.add(buttonCodeQR);
        toolpane.add(buttondelete);
        toolpane.add(buttonsave);
        toolpane.add(buttonok);

        add(toolpane, BorderLayout.SOUTH);

        setSize(800, 600);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new DashBoard();
            }
        });
    }
}