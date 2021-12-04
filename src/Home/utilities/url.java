package Home.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class url
{
    public  void show(String title,String url) throws IOException {
        Stage stage=new Stage();
        stage.setTitle(title);
        Parent root=FXMLLoader.load(getClass().getResource(url));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();



    }
}
