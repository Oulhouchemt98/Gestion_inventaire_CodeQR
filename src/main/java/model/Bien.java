package model;

import java.util.Date;

public class Bien {
    public int code;
    public String description;
    public String Etat;
    public Date date;
    public String genre;
    public Emplacement emp;

    public Bien(int c, String des, String E, Date d, String g, Emplacement e){
        this.code=c;
        this.description=des;
        this.Etat=E;
        this.date=d;
        this.genre =g;
        this.emp=e;
    }
    public void afficher(){
        System.out.println("code :"+code);
        System.out.println("description "+description);
        System.out.println("Etat :"+Etat);
        System.out.println("date :"+date);
        System.out.println("genre :"+genre);
        System.out.println("emp num :"+emp.numSalle);
        System.out.println("emp nom :"+emp.nomsalle);
    }

    public String genererCode(){
        return code+description+Etat+date+genre+emp.numSalle+emp.nomsalle;
    }

}
