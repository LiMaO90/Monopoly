import Model.Monopoly;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appli extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Monopoly");
        FenetreMenu fenetre = new FenetreMenu(this);
        Scene scene = new Scene(fenetre,500, 500, Color.LIGHTGREY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void lancerJeu(Color[] tabColor ,String[] nomJoueur){
        Monopoly monopoly = new Monopoly(nomJoueur, tabColor);
        final int Width = 600;
        final int Heigth = 600;

        PopUpArgent popUpArgent = new PopUpArgent(monopoly, primaryStage);
        PopUpEmprunt popUpEmprunt = new PopUpEmprunt(monopoly, primaryStage);

        PopUp popUp = new PopUp(popUpArgent, popUpEmprunt);

        Fenetre fenetre = new Fenetre(monopoly, popUp);
        Scene scene = new Scene(fenetre,Width,Heigth, Color.LIGHTGREY);

        primaryStage.setScene(scene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}