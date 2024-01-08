/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) { 
//à compléter
     this.voitures=voitures;
    }
public ListVoitures() {
//à compléter
    voitures=new ArrayList<>();
}
public List<Voiture> getVoitures() {
//à compléter
    return voitures;
}
public void setVoitures(List<Voiture> voitures) {
//à compléter
    this.voitures=voitures;
}
public void ajoutVoiture(Voiture v) throws VoitureException{
if(voitures.contains(v))
    throw new VoitureException("la voiture existe déjà");
else voitures.add(v);
}

public void supprimeVoiture(Voiture v) throws VoitureException{
// à compléter
    if(voitures.contains(v))
        voitures.remove(v);
    else throw new VoitureException("La voiture n'existe pas");
}

public int size(){
        return voitures.size();
}
public void affiche(){
        for (Voiture v:voitures)
        {
            System.out.println(v);
        }
        //Méthode 2
        for (int i=0;i<voitures.size();i++)
            System.out.println(voitures.get(i));
}

    @Override
    public String toString() {
String str="Liste voitures :\n";
        for (Voiture v:voitures)
        {
           str+=v+"\n";
        }
        return str;
    }

}
