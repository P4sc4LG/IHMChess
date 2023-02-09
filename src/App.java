import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundRepeat.*;
import java.util.ArrayList;
import java.util.List;	
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class App extends Application{
    private  String jWhite;
    private  String jBlack;
    int initialX,initialY,destinationX,destinationY;
    Piece selectedPiece;
    GridPane root = new GridPane();
    static List<Piece> lesPieces = new ArrayList();
    public String trait = "white";
    PauseTransition timerBlanc = new PauseTransition(Duration.minutes(1));
    PauseTransition timerNoir = new PauseTransition(Duration.minutes(1));
    
  
    
    @Override
    public void start(Stage stage){
    	
        Button startButton = new Button("Start");
        startButton.setId("button-style");
        Button leaveButton = new Button("Quit");
       
        leaveButton.setId("button-style");
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
                	Label labelBlanc = new Label();
                	labelBlanc.setFont(Font.font("Arial", 20));
                	labelBlanc.textProperty().bind(timeLeftAsString(timerBlanc));

                	labelBlanc.textProperty().addListener((observable, oldValue, newValue) -> {
                		if(newValue.equals("00:00")) {
                           
                            endGameScreen(stage, "le temps ",jBlack);
                  		}
                	});
                	Label labelNoir = new Label();
                	labelNoir.setFont(Font.font("Arial", 20));
                	labelNoir.textProperty().bind(timeLeftAsString(timerNoir));

                	labelNoir.textProperty().addListener((observable, oldValue, newValue) -> {
              		if(newValue.equals("00:00")) {
                       
                        endGameScreen(stage, "le temps ",jWhite);
              		}
              	});
                    jBlack = textFieldBlack.getText();
                    jWhite = textFieldWhite.getText();
                    Text nomJBlack = new Text("Joueur Noir : "+jBlack);
                    Text nomJWhiteV = new Text("Joueur Blanc : "+jWhite);
                    nomJBlack.setId("text-style-joueur-echec-stage");
                    nomJWhiteV.setId("text-style-joueur-echec-stage");
			
                    VBox v1 = new VBox();
                    v1.setPadding(new Insets(40,270,40,40));
                    v1.setBorder(new Border(new BorderStroke(Color.BLACK, 
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
                    v1.getChildren().addAll(nomJBlack,labelNoir);
                    
                    VBox v2 = new VBox();
                    v2.setPadding(new Insets(215,0,40,40));
                    v2.setBorder(new Border(new BorderStroke(Color.BLACK, 
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
                    v2.getChildren().addAll(nomJWhiteV,labelBlanc);
                    
                    VBox timer = new VBox(v1,v2);
                    
                    HBox mainContainer = new HBox(root,timer);
                    
                    Scene scene = new Scene(mainContainer,600,400);
                    
                	  
                      Color lightGray = Color.LIGHTGRAY;
                      Color darkGray = Color.DARKGRAY;
                      

                      for (int row = 0; row < 8; row++) {
                          for (int col = 0; col < 8; col++) {
                              if ((row + col) % 2 == 0) {
                              	Rectangle r = new Rectangle(50, 50, lightGray);
                                  GridPane.setRowIndex(r, row);
                                  GridPane.setColumnIndex(r, col);
                                  root.getChildren().add(r);
                                  r.setOnMouseClicked(new EventHandler<MouseEvent>() {

                              	    @Override
                              	    public void handle(MouseEvent t) {
                              	    	Rectangle r = (Rectangle)t.getTarget();
                              	    		if(r.getFill().equals(Color.DARKBLUE)) {
                              	    			if(getPieceByImageView( (ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root))!=null) {
                             	    				lesPieces.remove(getPieceByImageView( (ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root)));
                             	    				root.getChildren().remove((ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root));
                             	    			}
                              	    			root.getChildren().remove(selectedPiece.getV());
                              	    			root.add(selectedPiece.getV(), GridPane.getColumnIndex(r), GridPane.getRowIndex(r));
                              	    			
                              	    			selectedPiece.x=GridPane.getColumnIndex(r);
                              	    			selectedPiece.y=GridPane.getRowIndex(r);
                              	    			if(selectedPiece instanceof pion) { 
                                  	    			pion pp = (pion)selectedPiece;
                                  	    			pp.firstMove=false;
                                  	    			}
                              	    			if(selectedPiece.couleur.equals("black")) {
                                  	    			trait="white";
                                  	    			timerBlanc.play();
                                  	    			timerNoir.pause();
                                  	    		}
                                  	    		else {
                                  	    			trait="black";
                                  	    			timerNoir.play();
                                  	    			timerBlanc.pause();
                                  	    		}
                              	    			selectedPiece=null;
                              	    			resetColor();
                              	    		  System.out.println("trait : " +trait);
                              	    		}
                              	    	
                              	        }});
          
                              } else {
                              	 Rectangle r = new Rectangle(50, 50, darkGray);
                                   GridPane.setRowIndex(r, row);
                                   GridPane.setColumnIndex(r, col);
                                   root.getChildren().add(r);
                                   r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                 	    @Override
                                 	    public void handle(MouseEvent t) {
                                 	    	Rectangle r = (Rectangle)t.getTarget();
                                 	    		if(r.getFill().equals(Color.DARKBLUE)) {
                                 	    			if(getPieceByImageView( (ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root))!=null) {
                                 	    				lesPieces.remove(getPieceByImageView( (ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root)));
                                 	    				root.getChildren().remove((ImageView) getNodeByRowColumnIndex(GridPane.getRowIndex(r), GridPane.getColumnIndex(r), root));
                                 	    			}
                                 	    			root.getChildren().remove(selectedPiece.getV());
                                 	    			root.add(selectedPiece.getV(), GridPane.getColumnIndex(r), GridPane.getRowIndex(r));
                                 	    			if(selectedPiece instanceof pion) { 
                                      	    			pion pp = (pion)selectedPiece;
                                      	    			pp.firstMove=false;
                                      	    			}
                                 	    			selectedPiece.x=GridPane.getColumnIndex(r);
                                  	    			selectedPiece.y=GridPane.getRowIndex(r);
                                  	    			if(selectedPiece.couleur.equals("black")) {
                                      	    			trait="white";
                                      	    			timerBlanc.play();
                                      	    			timerNoir.pause();
                                      	    		}
                                      	    		else {
                                      	    			trait="black";
                                      	    			timerNoir.play();
                                      	    			timerBlanc.pause();
                                      	    		}
                                  	    			selectedPiece=null;
                                  	    			resetColor();
                                  	    		  System.out.println("trait : " +trait);
                                 	    		}
                                 	        }});
                              }
                          }
                      }
                   ;
                   	genPiece(stage);

                      timerBlanc.play();
                      
                      stage.setScene(scene);
                      stage.setTitle("JavaFX Chess Board");
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
    public void genPiece(Stage stage) {
    	   for (int i = 0; i < 8; i++) {
               pion p = new pion("black",i,1);
               lesPieces.add(p);
     
                root.add(p.getImageView(), i, 1);
                GridPane.setRowIndex(p.getImageView(), 1);
                GridPane.setColumnIndex(p.getImageView(), i);
                pion p2 = new pion("white",i,6);
                lesPieces.add(p2);
                root.add(p2.getImageView(), i, 6);
            }
    	   
    	   king king = new king("black",3,0);
    	   king king2 = new king("white",3,7);
    	   root.add(king.getImageView(), 3, 0);
    	   root.add(king2.getImageView(), 3, 7);
    	   
    	   
    	   queen queen = new queen("black",4,0);
    	   queen queen2 = new queen("white",4,7);
    	   root.add(queen.getImageView(), 4, 0);
    	   root.add(queen2.getImageView(), 4, 7);
    	   
    	   knight knight = new knight("black",6,0);
    	   knight knight2 = new knight("black",1,0);
    	   root.add(knight.getImageView(), 6, 0);
    	   root.add(knight2.getImageView(), 1,0 );
    	   
    	   knight knight3 = new knight("white",6,7);
    	   knight knight4 = new knight("white",1,7);
    	   root.add(knight3.getImageView(), 6, 7);
    	   root.add(knight4.getImageView(), 1,7 );
    	   
    	 
    	   bishop bishop = new bishop("black",5,0);
    	   bishop bishop2 = new bishop("black",2,0);
    	   root.add(bishop.getImageView(), 5, 0);
    	   root.add(bishop2.getImageView(), 2,0 );
    	   
    	   bishop bishop3 = new bishop("white",5,7);
    	   bishop bishop4 = new bishop("white",2,7);
    	   root.add(bishop3.getImageView(), 5, 7);
    	   root.add(bishop4.getImageView(), 2,7 );
    	   
    	   rook rook = new rook("black",7,0);
    	   rook rook1 = new rook("black",0,0);
    	   root.add(rook.getImageView(), 7, 0);
    	   root.add(rook1.getImageView(), 0,0 );
    	   
    	   rook rook2 = new rook("white",0,7);
    	   rook rook3 = new rook("white",7,7);
    	   root.add(rook2.getImageView(), 0, 7);
    	   root.add(rook3.getImageView(), 7,7 );
    	   lesPieces.add(queen);
    	   lesPieces.add(queen2);
    	   lesPieces.add(king);
    	   lesPieces.add(king2);
    	   lesPieces.add(rook3);
    	   lesPieces.add(rook2);
    	   lesPieces.add(rook);
    	   lesPieces.add(rook1);
    	   lesPieces.add(bishop4);
    	   lesPieces.add(bishop);
    	   lesPieces.add(bishop3);
    	   lesPieces.add(bishop2);
    	   lesPieces.add(knight);
    	   lesPieces.add(knight2);
    	   lesPieces.add(knight3);
    	   lesPieces.add(knight4);
    	   creerEventHandler(stage);
    	
    }
  private void creerEventHandler(Stage stage) {
	  for (Piece p :lesPieces) {
		  p.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {

      	    @Override
      	    public void handle(MouseEvent t) {
      	        ImageView v =(ImageView)t.getSource();
          	    Piece p =(Piece)getPieceByImageView(v);
          	    
      	    if(selectedPiece==null ) {
      	    	if(p.couleur.equals(trait)) {
      	    	resetColor();
      	    	selectedPiece=p;
      	    	p.afficheCase(lesPieces,root);
      	    	}
      	    	
      	    }else {
      	    	if(selectedPiece.couleur.equals(p.couleur)) {
      	    		resetColor();
      	    		selectedPiece=p;
      	    		p.afficheCase(lesPieces, root);
      	    	}else {
      	    		if( ((Rectangle) getRectByRowColumnIndex(p.getY(), p.getX(), root)).getFill().equals(Color.DARKBLUE)) {
      	    		if(selectedPiece instanceof pion) { 
      	    			pion pp = (pion)selectedPiece;
      	    			pp.firstMove=false;
      	    			}
      	    		selectedPiece.setX(p.getX());
      	    		selectedPiece.setY(p.getY());
      	    		lesPieces.remove(p);
      	    		root.getChildren().remove(p.getImageView());
      	    		root.getChildren().remove(selectedPiece.getV());
      	    		root.add(selectedPiece.getV(), selectedPiece.getX(), selectedPiece.getY());
      	    		if(selectedPiece.couleur.equals("black")) {
      	    			timerNoir.pause();
      	    			timerBlanc.play();
      	    			trait="white";
      	    		}
      	    		else {
      	    			timerNoir.play();
      	    			timerBlanc.pause();
      	    			trait="black";
      	    		}
      	    		 System.out.println("trait : " +trait);
      	    		selectedPiece=null;
      	    		resetColor();
      	    		}
      	    		if(p instanceof king) {
      	    			System.out.println("partie finis le joueur "+p.couleur+ "à perdu");
      	    			timerBlanc.stop();
      	    			timerNoir.stop();
                        String winner = (p.couleur.equals("black"))?jWhite:jBlack;
                        
                        endGameScreen(stage, "roi en echec et mat ",winner);
      	    		}
      	    }
      	    
      	    }
      	  }});
	  }
		
	}
  public void endGameScreen(Stage stage, String mess, String winner){
        System.out.println("partie finisss");
        Label blackWinLabel = new Label("Victoire de "+winner+" avec "+mess);
        //change interface 
        VBox vButton = new VBox();
        Button restart = new Button("Restart");
        restart.setOnAction(e -> {
                    timerBlanc = new PauseTransition(Duration.minutes(1));
                    timerNoir = new PauseTransition(Duration.minutes(1));
                    trait = "white";
                    lesPieces.clear();
                    selectedPiece = null;
                    
                    Label labelNoir = new Label();
                	labelNoir.setFont(Font.font("Arial", 20));
                	labelNoir.textProperty().bind(timeLeftAsString(timerNoir));
                    Label labelBlanc = new Label();
                	labelBlanc.setFont(Font.font("Arial", 20));
                	labelBlanc.textProperty().bind(timeLeftAsString(timerBlanc));

                	labelBlanc.textProperty().addListener((observable, oldValue, newValue) -> {
                		if(newValue.equals("00:00")) {
                            endGameScreen(stage, "le temps ",jBlack);
                  		}
                	});
                	labelNoir.textProperty().addListener((observable, oldValue, newValue) -> {
                        if(newValue.equals("00:00")) {
                            endGameScreen(stage, "le temps ",jWhite);
                        }
              	    });
                    
                    Text nomJBlack = new Text("Joueur Noir : "+jBlack);
                    Text nomJWhiteV = new Text("Joueur Blanc : "+jWhite);
                    nomJBlack.setId("text-style-joueur-echec-stage");
                    nomJWhiteV.setId("text-style-joueur-echec-stage");
                    VBox v1 = new VBox();
                    v1.setPadding(new Insets(40,270,40,40));
                    v1.setBorder(new Border(new BorderStroke(Color.BLACK, 
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
                    v1.getChildren().addAll(nomJBlack,labelNoir);
                    
                    VBox v2 = new VBox();
                    v2.setPadding(new Insets(215,0,40,40));
                    v2.setBorder(new Border(new BorderStroke(Color.BLACK, 
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
                    v2.getChildren().addAll(nomJWhiteV,labelBlanc);
                    
                    VBox timer = new VBox(v1,v2);
                    
                    HBox mainContainer = new HBox(root,timer);
                    
                    Scene scene = new Scene(mainContainer,600,400); 	  
                    Color lightGray = Color.LIGHTGRAY;
                    Color darkGray = Color.DARKGRAY;
                
                      for (int row = 0; row < 8; row++) {
                          for (int col = 0; col < 8; col++) {
                              if(getNodeByRowColumnIndex(row, col, root) != null){
                                    root.getChildren().remove(getNodeByRowColumnIndex(row, col, root));
                              }
                          }
                      }
                    
                    resetColor();
                   	genPiece(stage);

                    timerBlanc.play(); 
                    stage.setScene(scene);
                    stage.setTitle("JavaFX Chess Board");
                    stage.show();
        });

        restart.setId("button-style");
        Button leave = new Button("Quit");

        leave.setOnAction(e -> {
            stage.close();
        });
        leave.setId("button-style");
        vButton.setSpacing(10);
        vButton.getChildren().addAll(restart,leave);
        vButton.setAlignment(Pos.CENTER);
        if(winner.equals(jBlack)){
            vButton.setId("form-winner-black");
        }else{
            vButton.setId("form-winner-white");
        }
        
        Scene sc = new Scene(vButton,600,600);
        sc.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("End-Game");
        stage.setScene(sc);
        stage.show(); 
        //popup
        StackPane st = new StackPane();
        st.getChildren().add(blackWinLabel);
        Stage stageError = new Stage();
        Scene sceneError = new Scene(st,300,100);
        stageError.setScene(sceneError);
        stageError.setTitle("Defeat");
        stageError.show();
  }
  public Piece getPieceByImageView(ImageView v) {
	  for (int i = 0;i<lesPieces.size();i++) {
		  if (lesPieces.get(i).getV().equals(v)) {
			  return lesPieces.get(i);
		  }
	  }
	  return null;
  }
    
    public static void main(String[] args){
        launch(args);
    }
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column && node instanceof ImageView) {
                result = node;
                break;
            }
        }

        return result;
    }
    
    public Node getRectByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column && node instanceof Rectangle) {
                result = node;
                break;
            }
        }

        return result;
    }
    public void resetColor() {
    	for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                	Rectangle r= (Rectangle) getRectByRowColumnIndex(row, col, root);
                	r.setFill(Color.LIGHTGRAY);
                	
                }
                else {
                	Rectangle r= (Rectangle) getRectByRowColumnIndex(row, col, root);
                	r.setFill(Color.DARKGREY);
                }
                	}
                }
    	
    }
    public StringBinding timeLeftAsString(Animation animation) {
        return Bindings.createStringBinding(
            () -> {
              double currentTime = animation.getCurrentTime().toMillis();
              double totalTime = animation.getCycleDuration().toMillis();
              long remainingTime = Math.round(totalTime - currentTime);
              java.time.Duration dur = java.time.Duration.ofMillis(remainingTime);
              return String.format(
                  "%02d:%02d", dur.toMinutes(), dur.toSecondsPart());
            },
            animation.currentTimeProperty(),
            animation.cycleDurationProperty());
      }
    
}
//comment
