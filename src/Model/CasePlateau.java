package Model;

import java.awt.*;

public class CasePlateau {
    private String nom;
    private int prix;
    private ZoneAvenue zone;
    private boolean estPrit;
    private Joueur joueur;
    private Point positionCanvas;

    public CasePlateau(String nom, int prix, Point positionCanvas, ZoneAvenue zone) {
        this.nom = nom;
        this.prix = prix;
        this.zone = zone;
        this.positionCanvas = positionCanvas;
        estPrit = false;
        joueur = null;
    }
}
