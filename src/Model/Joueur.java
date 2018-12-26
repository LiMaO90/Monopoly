package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private Color couleurJoueur;
    private int[] nbBillets;                // ordre des billets: 1, 5, 10, 20, 50 ,100, 500
    private int[] nbBilletsEmprunter;                // ordre des billets: 1, 5, 10, 20, 50 ,100, 500
    private List<CasePlateau> listCasePrit;
    private CasePlateau casePlateauJoueur;


    public Joueur(String nom, Color couleurJoueur) {
        this.nom = nom;
        this.couleurJoueur = couleurJoueur;
        listCasePrit = new ArrayList<>();
        nbBillets = new int[]{5, 1, 2, 1, 1, 4, 2};
        nbBilletsEmprunter = new int[]{0, 0, 0, 0, 0, 0, 0};
    }

    public void emprunt(int[] nbBilletsEmprunter){
        for (int i = 0; i < 7; i++) {
            this.nbBilletsEmprunter[i] = this.nbBilletsEmprunter[i] + nbBilletsEmprunter[i];
            nbBillets[i] = nbBillets[i] + nbBilletsEmprunter[i];
        }
    }

    public String getNom() { return nom; }

    public int[] getNbBillets() { return nbBillets; }

    public int[] getNbBilletsEmprunter() { return nbBilletsEmprunter; }

    public boolean rembourser() {
        if(verifierRemboursement()){
            for (int i = 0; i < nbBilletsEmprunter.length; i++) {
                nbBillets[i] = nbBillets[i] - nbBilletsEmprunter[i];
                nbBilletsEmprunter[i] = 0;
            }
            return true;
        }
        return false;
    }

    private boolean verifierRemboursement(){
        for (int i = 0; i < nbBilletsEmprunter.length; i++) {
            if(nbBillets[i]<nbBilletsEmprunter[i]) return false;
        }
        return true;
    }
}
