import Model.Monopoly;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpEmprunt {
    private Monopoly monopoly;
    private VBox vBox;
    private Stage primaryStage;
    private Stage popup;
    private Fenetre fenetre;

    public PopUpEmprunt(Monopoly monopoly, Stage primaryStage){
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

    public void afficher(){
        vBox.getChildren().clear();
        vBox.getChildren().add(new Label("Emprunt :"));

        TextField[] tabTextField = new TextField[7];
        for (int i = 0; i < tabTextField.length; i++) {
            tabTextField[i] = new TextField("0");
        }

        for (int i = 0; i < 7; i++) {
            HBox hBoxBillet = new HBox();
            hBoxBillet.getChildren().add(tabTextField[i]);
            hBoxBillet.getChildren().add(new ImageView(new Image("Image/billet"+ i +".JPG")));
            vBox.getChildren().add(hBoxBillet);
        }
        Button buttonValider = new Button("Valider");
        buttonValider.setOnAction(value ->{
            verifierEmprunt(tabTextField);
        });
        vBox.getChildren().add(buttonValider);
        popup.show();
    }

    private void verifierEmprunt(TextField[] tabTextField) {
        int[] nbBilletsEmprunter = new int[7];
        boolean isErreur = false;
        for (int i = 0; i < nbBilletsEmprunter.length; i++) {
            if(!isEntier(tabTextField[i].getText())){
                fenetre.afficheErreur("Mettez un nombre", "Erreur de format");
                isErreur = true;
                break;
            }
            else{ nbBilletsEmprunter[i] = Integer.parseInt(tabTextField[i].getText()); }
        }
        if(!isErreur){
            monopoly.getTabJoueur()[monopoly.getJoueurCourant()].emprunt(nbBilletsEmprunter);
            popup.close();
        }
    }

    private static  boolean isEntier(String text) {
        try {
            Integer.valueOf(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setFenetre(Fenetre fenetre) { this.fenetre = fenetre; }
}
