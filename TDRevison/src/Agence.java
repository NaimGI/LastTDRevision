/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author wiemhjiri
 */
public class Agence {
 
    private String nom;
    private ListVoitures parking;    
    private Map<Client, ListVoitures> clientVoitureLoue; 

public Agence(String nom) {
this.nom=nom;
parking=new ListVoitures();
clientVoitureLoue=new HashMap<>();
}
public void ajoutVoiture(Voiture v) throws VoitureException{
parking.ajoutVoiture(v);
  
}
public void suppVoiture(Voiture v)throws VoitureException{
//à completer
    parking.supprimeVoiture(v);
}

public void loueClientVoiture(Client cl, Voiture v)throws VoitureException{
// à completer
    ListVoitures list=clientVoitureLoue.get(cl);
    if(list==null)
        list=new ListVoitures();

    this.suppVoiture(v);

    list.ajoutVoiture(v);
    clientVoitureLoue.put(cl,list);
}


public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
// à completer
    ListVoitures list=clientVoitureLoue.get(cl);
    if(list.size()==1) clientVoitureLoue.remove(cl);

    else{

        list.supprimeVoiture(v);
        this.ajoutVoiture(v);
        clientVoitureLoue.put(cl,list);
    }
}
public List<Voiture> selectVoitureSelonCritere(Critere c){
//à completer
    List<Voiture> list=new ArrayList<>();
    for (Voiture v:parking.getVoitures())
    {
        if(c.estSatisfaitPar(v))
            list.add(v);
    }
    return list;
}

public Set<Client> ensembleClientsLoueurs(){
   return clientVoitureLoue.keySet();
}

public Collection<ListVoitures> collectionVoituresLouees(){
// à completer
    return clientVoitureLoue.values();
}
public void afficheLesClientsEtLeursListesVoitures(){ 
//à compléter

    for (Map.Entry<Client,ListVoitures> mp:clientVoitureLoue.entrySet())
    {
        System.out.println("Client :"+mp.getKey());
       // mp.getValue().affiche();
        System.out.println(mp.getValue());
    }
}
public Map<Client, ListVoitures> triCodeCroissant(){
// à completer
   TreeMap<Client,ListVoitures> tre=new TreeMap<>() ;//Comparable
   tre.putAll(clientVoitureLoue);
   return tre;
}

public Map<Client, ListVoitures> triNomCroissant(){
    TreeMap<Client,ListVoitures> tre=new TreeMap<>(new TriNom()) ;//Comparable
    tre.putAll(clientVoitureLoue);
    return tre;
}
    public Map<Client, ListVoitures> triNomDecroissant(){
        TreeMap<Client,ListVoitures> tre=new TreeMap<>((c1,c2)->c2.getNom().compareTo(c1.getNom())) ;//Comparable
        tre.putAll(clientVoitureLoue);
        return tre;
    }

    public Map<Client, ListVoitures> triCodeDecroissant(){
        TreeMap<Client,ListVoitures> tre=new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return 0;
            }
        }) ;//Comparable
        tre.putAll(clientVoitureLoue);
        return tre;
    }
}
