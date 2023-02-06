import java.awt.Color;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundRepeat.*;
import static javafx.scene.layout.BackgroundSize.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{
    private  String jWhite;
    private  String jBlack;
    @Override
    public void start(Stage stage){
        Button startButton = new Button("Start");
        startButton.setId("button-style");
        Button leaveButton = new Button("Quit");
        leaveButton.setId("button-style");
        startButton.setOnAction(event ->{
            Label titre = new Label("Création des joueurs");
            titre.setPadding(new Insets(0,130,160,0));
            titre.setId("text-style-titre");
            HBox joueurWhite = new HBox(); 
            Label labelWhite = new Label();
            labelWhite.setId("text-style-joueur");
            labelWhite.setText("Nom du joueur Blanc : ");
            TextField textFieldWhite = new TextField();
            joueurWhite.getChildren().addAll(labelWhite,textFieldWhite);
            joueurWhite.setPadding(new Insets(0,0,50,0));

            HBox joueurBlack = new HBox(); 
            Label labelBlack = new Label();
            labelBlack.setId("text-style-joueur");
            labelBlack.setText("Nom du joueur Noir : ");
            TextField textFieldBlack = new TextField();
            joueurBlack.getChildren().addAll(labelBlack,textFieldBlack);
            

            Button submitButton = new Button("Valider");
            submitButton.setId("button-style-submit");
            submitButton.setOnAction(e -> {
                if(textFieldBlack.getText().trim().equals("") 
                || textFieldWhite.getText().trim().equals("")){
                    Label labelError = new Label("Erreur veuillez mettre un nom");
                    labelError.setStyle("-fx-font-weight: bold;-fx-text-fill:red;");
                    StackPane st = new StackPane();
                    st.getChildren().add(labelError);
                    Stage stageError = new Stage();
                    Scene sceneError = new Scene(st,200,100);
                    stageError.setScene(sceneError);
                    stageError.setTitle("Error");
                    stageError.show();
                }else{
                    jWhite = textFieldWhite.getText();
                    jBlack = textFieldBlack.getText();
                    Label blackLabel = new Label("Joueur Noir : "+jBlack);
                    Label whiteLabel = new Label("Joueur Blanc : "+jWhite);
                    
                    VBox vb = new VBox(blackLabel,whiteLabel);
                    vb.setAlignment(Pos.CENTER);
                    vb.setPadding(new Insets(15,15,15,150));
                    Scene sc = new Scene(vb,600,600);
                    stage.setTitle("Echec");
                    stage.setScene(sc);
                    stage.show();
                }
            });
            VBox vChoix = new VBox(titre,joueurWhite,joueurBlack,submitButton);
            vChoix.setPadding(new Insets(15,15,15,150));
            vChoix.setBackground(new Background(new BackgroundImage(new Image("background/backgroundJoueur.jpg")
                                , NO_REPEAT, NO_REPEAT, CENTER, new BackgroundSize(1.5, 1.5, true, true, false, false))));
            vChoix.setAlignment(Pos.CENTER);
            vChoix.setSpacing(10);
            Scene sc = new Scene(vChoix,600,600);
            sc.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            stage.setTitle("Création des joueurs");
            stage.setScene(sc);
            stage.show();
        });
        leaveButton.setOnAction(e -> {
            stage.close();
        });
        Label titre = new Label();
        titre.setText("CHESS GAME");
        titre.setPadding(new Insets(0,0,380,0));
        titre.setStyle("-fx-text-fill: White;-fx-font-weight:bold");
        titre.setFont(Font.font("Arial",50));
        VBox vMenu = new VBox();
        
        vMenu.getChildren().addAll(titre,startButton,leaveButton);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.CENTER);
        vMenu.setId("form-menu");
        Scene sc = new Scene(vMenu,600,600);
        sc.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Menu");
        stage.setScene(sc);
        stage.show();  
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
