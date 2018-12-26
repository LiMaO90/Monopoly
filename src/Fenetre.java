import Model.Monopoly;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Fenetre extends Parent {
    private Monopoly monopoly;
    private PopUp popUp;
    private GraphicsContext graphicsContext;
    private Label labelJoueur;

    public Fenetre(Monopoly monopoly, PopUp popUp) {
        this.popUp = popUp;
        popUp.getPopUpEmprunt().setFenetre(this);
        this.monopoly = monopoly;
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        Canvas canvas = new Canvas(600, 600);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(new Image("Image/plateauMonopoly.jpeg"), 0, 0);
        initInfoJoueur(borderPane);
        vBox.getChildren().add(borderPane);
        vBox.getChildren().add(canvas);
        this.getChildren().add(vBox);
    }

    private void initInfoJoueur(BorderPane borderPane){
        labelJoueur = new Label(monopoly.getTabJoueur()[monopoly.getJoueurCourant()].getNom());

        HBox hBox = new HBox();
        Button buttonJoueurSuivant = new Button("Joueur suivant");
        buttonJoueurSuivant.setOnAction(value ->{
            monopoly.joueurSuivant();
            actualiserJeu();
        });

        Button buttonEmprunt = new Button("Emprunter");
        buttonEmprunt.setOnAction(value ->{
            popUp.getPopUpEmprunt().afficher();
        });

        hBox.getChildren().addAll(buttonEmprunt, buttonJoueurSuivant);

        HBox hBoxArgent = new HBox();
        Button buttonJoueurArgent = new Button("Mon argent");
        buttonJoueurArgent.setOnAction(value ->{
            popUp.getPopUpArgent().afficherMonArgent();
            actualiserJeu();
        });

        Button buttonJoueurArgentEmprunter = new Button("Argent Emprunter");
        buttonJoueurArgentEmprunter.setOnAction(value ->{
            popUp.getPopUpArgent().afficherArgentEmprunter();
            actualiserJeu();
        });

        Button buttonJoueurRembourser = new Button("Rembourser");
        buttonJoueurRembourser.setOnAction(value ->{
            if(!monopoly.rembourser()){ afficheErreur("Vous n'avez pas assez d'argent pour rembourser", "Remborsement impossible"); }
        });

        hBoxArgent.getChildren().addAll(buttonJoueurArgent, buttonJoueurArgentEmprunter, buttonJoueurRembourser);

        borderPane.setLeft(hBoxArgent);
        borderPane.setRight(hBox);
        borderPane.setCenter(labelJoueur);
    }

    public void actualiserJeu() {
        labelJoueur.setText(monopoly.getTabJoueur()[monopoly.getJoueurCourant()].getNom());
    }

    public void afficheErreur(String erreur, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);

        alert.setContentText(erreur);
        alert.showAndWait();
    }
}