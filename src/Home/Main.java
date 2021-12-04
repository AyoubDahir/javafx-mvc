package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import Home.utilities.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
     url obj=new url();
     obj.show("login","/Home/view/login.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
