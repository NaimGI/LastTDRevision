/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wiemhjiri
 */
public class CritereMarque implements Critere{

    private String marque;

   public CritereMarque(String marque)
    {
        this.marque=marque;
    }
    @Override
    public boolean estSatisfaitPar(Voiture v) {

// à compléter
        return v.getMarque().equals(marque);
    }
    
}
