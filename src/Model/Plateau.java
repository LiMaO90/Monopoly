package Model;

import java.awt.*;

public class Plateau {
    private CasePlateau[] listCase;

    public Plateau() {
        listCase = new CasePlateau[]{
            new CasePlateau("Départ", 0, new Point(), null),
            new CasePlateau("Boulevard de Belleville", 60, new Point(), ZoneAvenue.rose),
            new CasePlateau("Caisse De Communauté", 0, new Point(), ZoneAvenue.caisse),
            new CasePlateau("Rue Lecourbe", 60, new Point(), ZoneAvenue.rose),
            new CasePlateau("Impots sur le Revenu", -200, new Point(), ZoneAvenue.paye),
            new CasePlateau("Gare Montparnasse", 200, new Point(), ZoneAvenue.gare),
            new CasePlateau("Rue de Vaugirard", 100, new Point(), ZoneAvenue.bleuClair),
            new CasePlateau("Chance", 0, new Point(), ZoneAvenue.chance),
            new CasePlateau("Rue de Courcelles", 100, new Point(), ZoneAvenue.bleuClair),
            new CasePlateau("Aveneue de la République", 120, new Point(), ZoneAvenue.bleuClair),

            new CasePlateau("Simple Visite", 0, new Point(), null),
            new CasePlateau("Boulevard de la villette", 140, new Point(), ZoneAvenue.violet),
            new CasePlateau("Compagnie de Distribution d'électricité", 150, new Point(), ZoneAvenue.compagnie),
            new CasePlateau("Avenue de Neuilly", 140, new Point(), ZoneAvenue.violet),
            new CasePlateau("Rue de Paradis", 160, new Point(), ZoneAvenue.violet),
            new CasePlateau("Gare de lyon", 200, new Point(), ZoneAvenue.gare),
            new CasePlateau("Avenue Mozart", 180, new Point(), ZoneAvenue.orange),
            new CasePlateau("caisse de Communauté", 0, new Point(), ZoneAvenue.caisse),
            new CasePlateau("Boulevard Saint-Michel", 180, new Point(), ZoneAvenue.orange),
            new CasePlateau("Place Pigalle", 200, new Point(), ZoneAvenue.orange),

            new CasePlateau("Parc Gratuit", 0, new Point(), null),
            new CasePlateau("Avenue Matignon", 220, new Point(), ZoneAvenue.rouge),
            new CasePlateau("Chance", 0, new Point(), ZoneAvenue.chance),
            new CasePlateau("Boulevard Malesherbes", 220, new Point(), ZoneAvenue.rouge),
            new CasePlateau("Avenue Henri-Martin", 240, new Point(), ZoneAvenue.rouge),
            new CasePlateau("Gare du Nord", 200, new Point(), ZoneAvenue.gare),
            new CasePlateau("Faubourg Saint-Honoré", 260, new Point(), ZoneAvenue.jaune),
            new CasePlateau("Place de la bourse", 260, new Point(), ZoneAvenue.jaune),
            new CasePlateau("Compagnie de distribution des eaux", 150, new Point(), ZoneAvenue.compagnie),
            new CasePlateau("Rue la Fayette", 280, new Point(), ZoneAvenue.jaune),

            new CasePlateau("Allez en prison", 0, new Point(), null),
            new CasePlateau("Avenue de Breteuil", 300, new Point(), ZoneAvenue.vert),
            new CasePlateau("Avenue Foch", 300, new Point(), ZoneAvenue.vert),
            new CasePlateau("Caisse de Communauté", 0, new Point(), ZoneAvenue.caisse),
            new CasePlateau("Boulevard des capucines", 320, new Point(), ZoneAvenue.violet),
            new CasePlateau("Gare Saint-Lazare", 200, new Point(), ZoneAvenue.gare),
            new CasePlateau("Chance", 0, new Point(), ZoneAvenue.chance),
            new CasePlateau("Avenue des chanps-élysées", 350, new Point(), ZoneAvenue.bleuFonce),
            new CasePlateau("Taxe de luxe", -100, new Point(), ZoneAvenue.paye),
            new CasePlateau("Rue de la paix", 400, new Point(), ZoneAvenue.bleuFonce)
        };
    }

    public CasePlateau[] getListCase() { return listCase; }
}
