import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage pS){
        Button btn = new Button();
        btn.setText("aze");
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.out.println("HW");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene sc = new Scene(root,300,500);
        pS.setTitle("aze");
        pS.setScene(sc);
        pS.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
