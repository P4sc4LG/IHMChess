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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{
    private  String jWhite;
    private  String jBlack;
    @Override
    public void start(Stage stage){
        Button startButton = new Button("Start");
        Button leaveButton = new Button("Quit");
        /*btn.setOnAction(e -> {
            StackPane root2 = new StackPane();
            Label label = new Label("Second form");
            root2.getChildren().add(label);
            Scene secondScene = new Scene(root2,600,600);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene);
            secondStage.setTitle("second form");
            secondStage.show();
            stage.close();
        });*/
        startButton.setOnAction(event ->{

            HBox joueurWhite = new HBox(); 
            Label labelWhite = new Label();
            labelWhite.setText("Nom du joueur Blanc : ");
            TextField textFieldWhite = new TextField();
            joueurWhite.getChildren().addAll(labelWhite,textFieldWhite);
            joueurWhite.setPadding(new Insets(0,0,50,0));

            HBox joueurBlack = new HBox(); 
            Label labelBlack = new Label();
            labelBlack.setText("Nom du joueur Noir : ");
            TextField textFieldBlack = new TextField();
            joueurBlack.getChildren().addAll(labelBlack,textFieldBlack);
            
            Button submitButton = new Button("Valider");
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
            VBox vb = new VBox(joueurWhite,joueurBlack,submitButton);
            vb.setAlignment(Pos.CENTER);
            vb.setPadding(new Insets(15,15,15,150));
            Scene sc = new Scene(vb,600,600);
            stage.setTitle("Création des joueurs");
            stage.setScene(sc);
            stage.show();
        });
        StackPane root = new StackPane();
        root.getChildren().add(startButton);
        Scene sc = new Scene(root,600,600);
        stage.setTitle("Menu");
        stage.setScene(sc);
        stage.show();  
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
