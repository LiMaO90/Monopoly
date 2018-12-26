package Model;

import javafx.scene.paint.Color;

public class Monopoly {
    private Joueur[] tabJoueur;
    private InitCarte initCarte;
    private int joueurCourant;
    private int nbJoueur;
    private Plateau plateau;

    public Monopoly(String[] tabJoueur, Color[] tabColor) {
        initCarte = new InitCarte();
        plateau = new Plateau();
        nbJoueur = tabJoueur.length;
        this.tabJoueur = new Joueur[nbJoueur];
        for (int i = 0; i < nbJoueur; i++) {
            this.tabJoueur[i] = new Joueur(tabJoueur[i], tabColor[i]);
        }
        joueurCourant = 0;
    }

    public void joueurSuivant() {
        joueurCourant++;
        joueurCourant = joueurCourant%nbJoueur;
    }

    public Joueur[] getTabJoueur() { return tabJoueur; }

    public int getJoueurCourant() { return joueurCourant; }

    public boolean rembourser() {
        return tabJoueur[joueurCourant].rembourser();
    }
}