package Com.Java.AccountingSystem.MainClassPackage.Numfor.Elmer.Chenemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AccountingSystemMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AccountingSystemUserInterface.fxml"));

        Scene scene = new Scene(root);

        Image image = new Image("/Com/Java/AccountingSystem/AppImagePackage/Numfor/Elmer/Chenemo/AppLogo.png");
        stage.getIcons().add(image);

        stage.setTitle("ACCOUNTING || BY N.ELMER");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
