/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wiemhjiri
 */
public class AgenceDeLOcationDeVoiture3A12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Voiture v1=new Voiture(123,"golf",100);
        Voiture v2=new Voiture(125,"golf",70);
        Voiture v3=new Voiture(126,"ibiza",80);

        Agence ag=new Agence("Araiana");
        try {
            ag.ajoutVoiture(v1);
        }catch (VoitureException ex)
        {
            System.out.println(ex);
        }
        try {
            ag.ajoutVoiture(v2);
        }catch (VoitureException ex)
        {
            System.out.println(ex);
        }
        try {
            ag.ajoutVoiture(v3);
        }catch (VoitureException ex)
        {
            System.out.println(ex);
        }
        try {
            ag.ajoutVoiture(v1);
        }catch (VoitureException ex)
        {
            System.out.println(ex);
        }

        List<Voiture> l1=ag.selectVoitureSelonCritere(new CritereMarque("golf"));
        System.out.println(l1);

        List<Voiture> l2=ag.selectVoitureSelonCritere(new CriterePrix(80));
        System.out.println(l2);

        List<Voiture> l3=ag.selectVoitureSelonCritere((Voiture v)->
        {return v.getMarque().equals("golf")&&v.getPrixLocation()==70;});
        System.out.println(l3);

        List<Voiture> l4=ag.selectVoitureSelonCritere(v->
        v.getMarque().equals("golf")&&v.getPrixLocation()==70);


        ArrayList<Voiture> list1=new ArrayList<>();
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);

        list1.stream().
                filter(v->
                v.getMarque().equals("golf")&&v.getPrixLocation()==70).forEach(e-> System.out.println(e));
    }
    
}
