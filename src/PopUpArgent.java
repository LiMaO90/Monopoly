import Model.Joueur;
import Model.Monopoly;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PopUpArgent extends Parent {
    private Monopoly monopoly;
    private VBox vBox;
    private Stage primaryStage;
    private Stage popup;

    public PopUpArgent(Monopoly monopoly, Stage primaryStage){
        popup = new Stage();
        this.monopoly = monopoly;
        this.primaryStage = primaryStage;
        vBox = new VBox();
        initPopup();
    }

    private void initPopup(){
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        Scene scene = new Scene(vBox);
        popup.setScene(scene);
    }

    public void afficherMonArgent(){
        vBox.getChildren().clear();
        Joueur joueur = monopoly.getTabJoueur()[monopoly.getJoueurCourant()];
        vBox.getChildren().add(new Label("Mon Argent :"));

        for (int i = 0; i < 7; i++) {
            HBox hBoxBillet = new HBox();
            hBoxBillet.getChildren().add(new Label(joueur.getNbBillets()[i] +" X"));
            hBoxBillet.getChildren().add(new ImageView(new Image("Image/billet"+ i +".JPG")));
            vBox.getChildren().add(hBoxBillet);
        }
        popup.show();
    }

    public void afficherArgentEmprunter(){
        vBox.getChildren().clear();
        Joueur joueur = monopoly.getTabJoueur()[monopoly.getJoueurCourant()];
        vBox.getChildren().add(new Label("Argent Emprunter :"));

        for (int i = 0; i < 7; i++) {
            HBox hBoxBillet = new HBox();
            hBoxBillet.getChildren().add(new Label(joueur.getNbBilletsEmprunter()[i] +" X"));
            hBoxBillet.getChildren().add(new ImageView(new Image("Image/billet"+ i +".JPG")));
            vBox.getChildren().add(hBoxBillet);
        }
        popup.show();
    }
}
